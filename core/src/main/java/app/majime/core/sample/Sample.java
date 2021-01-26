package app.majime.core.sample;


import app.majime.core.sample.usecase.GetSample;
import app.majime.core.sample.usecase.SetSample;

import javax.persistence.*;

@Entity
public class Sample implements GetSample, SetSample {

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

    @Override
    public Long getId(){
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int getSample_no() {
        return sample_no;
    }

    @Override
    public void setSample_no(int sample_no) {
        this.sample_no = sample_no;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int getBatch_id() {
        return batch_id;
    }

    @Override
    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    @Override
    public int getUser_id() {
        return user_id;
    }

    @Override
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public int getSpecification_id() {
        return specification_id;
    }

    @Override
    public void setSpecification_id(int specification_id) {
        this.specification_id = specification_id;
    }
}
