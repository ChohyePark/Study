package dto;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class MessagesDTO {

	private int seq;
	private String writer;
	private String message;
	private Timestamp write_date;
	
	
	
	
	
	public MessagesDTO(int seq, String writer, String message, Timestamp write_date) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.message = message;
		this.write_date = write_date;	
	
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	
	public String getFormedDate () {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		String formedDate = sdf.format(this.write_date);
		return formedDate;
	}
	
	
	
}
