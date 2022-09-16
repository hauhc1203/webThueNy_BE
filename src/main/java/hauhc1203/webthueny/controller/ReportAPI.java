package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.Report;
import hauhc1203.webthueny.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
