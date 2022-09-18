package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.Feedback;
import hauhc1203.webthueny.models.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ReportRepo extends PagingAndSortingRepository<Report,Long> {
    @Query(nativeQuery = true,value = "select  * from reportsss")
    Page<Report> findAllR(Pageable pageable);
    Report findByFromIdAndAboutId(long idU,long idO);

    @Query(nativeQuery = true,value = "SELECT * FROM reportsss where is_confirm = 1")
    List<Report> showReportConfirm();
    @Query(nativeQuery = true,value = "SELECT * FROM reportsss where is_confirm = 0")
    List<Report>showReportBad();

    @Query(nativeQuery = true,value = "SELECT * FROM reportsss where id=:id")
    Report findReportById(long id);


}
