package voe.company.OutfitsCompletedOfLog.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;

@Data
@Entity
@Table(name ="outfits_journal")
public class JournalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private Integer numberOutfit;
    @Column(name = "date")
    private String date;
    @Column(name = "dispatcher_num_eac")
    private Integer dispatcherNameEts;
    @Column(name = "type_eac")
    private String typeEac;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "performer")
    private String performer;

    public JournalEntity(Integer numberOutfit,
                         String date,
                         String typeEac,
                         Integer dispatcherNameEts,
                         String jobDescription,
                         String performer) {
        this.numberOutfit = numberOutfit;
        this.date = date;
        this.typeEac = typeEac;
        this.dispatcherNameEts = dispatcherNameEts;
        this.jobDescription = jobDescription;
        this.performer = performer;
    }

    public JournalEntity() {}
}
