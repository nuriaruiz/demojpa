package com.nuria.demojpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DATA_ENTITY")
public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false)
    private String field1;
    @Basic(optional = false)
    @Column(nullable = false)
    private String field2;
    @Basic(optional = false)
    @Column(nullable = false)
    private String field3;
    @Basic(optional = false)
    @Column(nullable = false)
    private String field4;

    public DataEntity(String field1, String field2, String field3, String field4) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    public static DataEntity from(String field1, String field2, String field3, String field4) {
        return new DataEntity(field1, field2, field3, field4);
    }

    @Override
    public String toString() {
        final StringBuilder toStringBuilder = new StringBuilder(getClass().getSimpleName());
        toStringBuilder.append("{ id=").append(id);
        toStringBuilder.append(", field1='").append(field1).append('\'');
        toStringBuilder.append(", field2='").append(field2).append('\'');
        toStringBuilder.append(", field3='").append(field3).append('\'');
        toStringBuilder.append(", field4=").append(field4);
        toStringBuilder.append('}');
        return toStringBuilder.toString();
    }
}
