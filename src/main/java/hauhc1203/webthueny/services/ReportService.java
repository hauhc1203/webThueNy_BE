package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Feedback;
import hauhc1203.webthueny.models.Report;
import hauhc1203.webthueny.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    ReportRepo reportRepo;
    @Autowired
    AppUserService appUserService;

    public Report save(Report report){
        return reportRepo.save(report);
    }

    public Report create(Report report){
        AppUser appUser=appUserService.getAppUserByUserDetail();
        report.setFrom(appUser);
        return save(report);
    }

    public Page<Report> getReport(Pageable pageable){
        return reportRepo.findAllR(pageable);
    }
    public Report getRByORandUSer(long idO){
        AppUser appUser=appUserService.getAppUserByUserDetail();

        return  reportRepo.findByFromIdAndAboutId(appUser.getId(),idO);

    }
    public List<Report>reportNotConfirm (){
        return reportRepo.showReportBad();

    }
    public List<Report>reportConfirm(){
        return reportRepo.showReportConfirm();
    }

public Report showDetailReport(long id){
        return reportRepo.findReportById(id);

}

}

