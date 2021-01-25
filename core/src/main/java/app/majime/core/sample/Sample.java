package app.majime.core.sample;

import javax.persistence.*;

@Entity
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int sample_no;
    private int quantity;
    private int status;
    private int batch_id;
    private int user_id;
    private int specification_id;

    protected Sample() {}

    public Sample(int sample_no) {
        this.sample_no = sample_no;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSample_no() {
        return sample_no;
    }

    public void setSample_no(int sample_no) {
        this.sample_no = sample_no;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSpecification_id() {
        return specification_id;
    }

    public void setSpecification_id(int specification_id) {
        this.specification_id = specification_id;
    }
}
