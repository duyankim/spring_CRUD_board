package kr.ac.kopo.kopo03.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class BoardItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    
    @Column
    private String title, author;
    
    @Column(columnDefinition = "TEXT")
    private String content;
    
	@ManyToOne(optional=false)
	@JoinColumn(name="board_id")
	private Board board;

	@PrePersist
	void createAt() {
		this.date= new Date();
	}
}
