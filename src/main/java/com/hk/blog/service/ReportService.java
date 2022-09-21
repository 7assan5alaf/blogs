package com.hk.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.blog.model.Blog;
import com.hk.blog.model.Report;
import com.hk.blog.repository.ReportRepository;
import com.hk.blog.view.ApiResopnse;
import com.hk.blog.view.ReportResponse;

@Service
public class ReportService {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private ReportRepository reportRepository;
//	@Autowired
//	private BlogRepository blogRepository;
//    @Autowired
//    private UserRepository userRepository;
	public ApiResopnse addReport(String blogId, Report report) {
		Blog blog=blogService.findById(blogId);
		report.setUser(blog.getUser());
		blog.setReport(report);
		reportRepository.save(report);
		return new ApiResopnse("send report to admin successfully", "success");
	}
	public List<ReportResponse> findAll() {
		List<Report>reports=reportRepository.findAll();
		List<ReportResponse>list=new ArrayList<>();
		for(Report r:reports) {
			list.add(new ReportResponse(r.getId(),r.getUser().getId(), r.getUser().getFullName(), r.getBody()));
		}
		return list;
	}

}
