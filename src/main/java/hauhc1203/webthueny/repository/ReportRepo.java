package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReportRepo extends PagingAndSortingRepository<Report,Long> {
    @Query(nativeQuery = true,value = "select  * from reportsss")
    Page<Report> findAllR(Pageable pageable);
    Report findByFromIdAndAboutId(long idU,long idO);
}
