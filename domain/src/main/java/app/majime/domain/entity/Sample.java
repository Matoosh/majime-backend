package app.majime.domain.entity;

public class Sample {

    private Long Id;
    private String sample_no;
    private float quantity;
    private int status;
    private int batch_id;
    private int user_id;
    private int specification_id;

    public Sample() {
    }

    public Sample(Long id, String sample_no, float quantity, int status, int batch_id, int user_id, int specification_id) {
        Id = id;
        this.sample_no = sample_no;
        this.quantity = quantity;
        this.status = status;
        this.batch_id = batch_id;
        this.user_id = user_id;
        this.specification_id = specification_id;
    }

    public static SampleBuilder builder() {
        return new SampleBuilder();
    }

    public static class SampleBuilder {
        private Long Id;
        private String sample_no;
        private float quantity;
        private int status;
        private int batch_id;
        private int user_id;
        private int specification_id;

        SampleBuilder() {
        }

        public SampleBuilder id(final Long id) {
            this.Id = id;
            return this;
        }

        public SampleBuilder sample_no(final String sample_no) {
            this.sample_no = sample_no;
            return this;
        }

        public SampleBuilder quantity(final float quantity) {
            this.quantity = quantity;
            return this;
        }

        public SampleBuilder status(final int status) {
            this.status = status;
            return this;
        }

        public SampleBuilder batch_id(final int batch_id) {
            this.batch_id = batch_id;
            return this;
        }

        public SampleBuilder user_id(final int user_id) {
            this.user_id = user_id;
            return this;
        }

        public SampleBuilder specification_id(final int specification_id) {
            this.specification_id = specification_id;
            return this;
        }

        public Sample build() {
            return new Sample(Id,sample_no,quantity,status,batch_id,user_id,specification_id);
        }
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getSample_no() {
        return sample_no;
    }

    public void setSample_no(String sample_no) {
        this.sample_no = sample_no;
    }

    public float getQuantity() {
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

    @Override
    public String toString() {
        return "Sample{" +
                "Id=" + Id +
                ", sample_no='" + sample_no + '\'' +
                ", quantity=" + quantity +
                ", status=" + status +
                ", batch_id=" + batch_id +
                ", user_id=" + user_id +
                ", specification_id=" + specification_id +
                '}';
    }

}
