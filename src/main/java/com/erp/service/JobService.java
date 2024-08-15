package com.erp.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.JobDAO;
import com.erp.dao.ServiceTypeDAO;
import com.erp.entities.JobDTO;
import com.erp.entities.ServiceTypeDTO;
import com.erp.entities.UserDTO;
import com.erp.helper.ResponseMessage;
import com.erp.model.JobModel;
import com.erp.model.UserModel;
import com.erp.utility.PortalConstants;
import com.erp.utility.PrepareDTO;
import com.erp.utility.PrepareModel;

@Service
public class JobService {

	@Autowired
	private JobDAO jobDAO;
	
	@Autowired
	private ServiceTypeDAO serviceTypeDAO;

	@Autowired
	private ResourcesService resourcesService;

	@org.springframework.transaction.annotation.Transactional
	public JobModel saveJob(JobModel jobModel, UserModel userModel) {
		jobModel.setCreatedDate(new Date());
		jobModel.setUser_id(userModel.getId());
		System.out.println("User id {" + userModel.getId() + "} jobModel id {"+jobModel.getId()+"}");
		if(jobModel.getStatus()==null) {
			jobModel.setStatus("Open");
		}
		JobDTO jobDTO = PrepareDTO.prepareJobDTO(jobModel);
		List<ServiceTypeDTO> serviceTypeList = jobDTO.getServices();
		serviceTypeList = serviceTypeDAO.saveAll(serviceTypeList);
		jobDTO.setServices(serviceTypeList);
		jobDTO = jobDAO.save(jobDTO);
		System.out.println("Job Created Successfully");
		return PrepareModel.prepareJobModel(jobDTO);
	}

	public List<JobModel> getAllJobsByUsername(int userid) {
		List<JobDTO> jobDTOList = jobDAO.findByUserId(userid);
		List<JobModel> jobModelList = jobDTOList.stream().map(dto -> converJobKeytoJobValue(PrepareModel.prepareJobModel(dto)))
				.collect(Collectors.toList());
		return jobModelList;
	}
	
	public List<JobModel> getAllJobs(String username) {
		List<JobDTO> jobDTOList = jobDAO.findAll();
		List<JobModel> jobModelList = jobDTOList.stream().map(dto -> converJobKeytoJobValue(PrepareModel.prepareJobModel(dto)))
				.collect(Collectors.toList());
		return jobModelList;
	}

	private JobModel converJobKeytoJobValue(JobModel jobModel) {
		String[] serviceTypes = jobModel.getServices();
		System.out.println("serviceTypes : " + serviceTypes);
		Stream.of(serviceTypes).forEach(a -> System.out.println(a));
		serviceTypes = Stream.of(serviceTypes)
				.map(b -> (resourcesService.getKeyValueList(PortalConstants.ServiceTypes).stream()
						.filter(a -> a.getKey().equals(b)).map(a -> a.getValue()).findFirst()).get())
				.toArray(String[]::new);
		jobModel.setServices(serviceTypes);
		return jobModel;
	}

	public JobModel getJobByJobId(int jobId) {
		Optional<JobDTO> jobDTO =  jobDAO.findById(jobId);
		JobModel jobModel;
		if(jobDTO.isPresent()) {
			jobModel = PrepareModel.prepareJobModel(jobDTO.get());
		}else {
			jobModel = new JobModel();
		}
		return jobModel;
	}
	
	
	public ResponseMessage deleteJob(int jobId) {
		ResponseMessage responseMessage = new ResponseMessage();
		try{
			jobDAO.deleteById(jobId);
			responseMessage.setType(responseMessage.success);
			responseMessage.setMessage("Job {"+jobId+"} deleted successfully." );
			
		}catch(Exception e) {
			System.out.println("Exception in Deleting job : "+e.getMessage());
			responseMessage.setType(responseMessage.success);
			responseMessage.setMessage("Job {"+jobId+"} deletion failed with reason {"+e.getLocalizedMessage()+"}" );
			e.printStackTrace();
		}
		return null;
	}

}
