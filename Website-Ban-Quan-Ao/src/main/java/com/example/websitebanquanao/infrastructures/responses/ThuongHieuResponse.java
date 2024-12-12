package com.example.websitebanquanao.infrastructures.responses;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThuongHieuResponse {
    private Integer id;
    private String ten;
    private Date ngay_tao;
    private Date ngay_sua;
    private int trang_thai;
}