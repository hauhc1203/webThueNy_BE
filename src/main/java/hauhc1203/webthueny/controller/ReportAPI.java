package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.Feedback;
import hauhc1203.webthueny.models.Report;
import hauhc1203.webthueny.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("report")
@CrossOrigin("*")
public class ReportAPI
{
    @Autowired
    ReportService reportService;


    @PostMapping
    public ResponseEntity<Report> create(@RequestBody Report report){
        return new ResponseEntity<>(reportService.create(report), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<Page<Report>> getReport(@RequestParam int page){
        return new ResponseEntity<>(reportService.getReport(PageRequest.of(page,8)),HttpStatus.OK);
    }
    @GetMapping("/{idOrder}")
    public ResponseEntity<Report> getReportByOrderandAcc(@PathVariable long idOrder){
        return new ResponseEntity<>(reportService.getRByORandUSer(idOrder),HttpStatus.OK);
    }
    @GetMapping("/reportNotConfirm")
    public ResponseEntity<List<Report>>reportNConfirm(){
        return new ResponseEntity<>(reportService.reportNotConfirm(),HttpStatus.OK);
    }
    @GetMapping("/reportConfirm")
    public ResponseEntity<List<Report>>reportConfirm(){
        return new ResponseEntity<>(reportService.reportConfirm(),HttpStatus.OK);
    }
    @GetMapping("/detailReport/{id}")
    public ResponseEntity<Report>detailReport(@PathVariable long id){
        return new ResponseEntity<>(reportService.showDetailReport(id),HttpStatus.OK);
    }


}
