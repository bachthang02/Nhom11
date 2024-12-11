package com.example.websitebanquanao.repositories;

import com.example.websitebanquanao.entities.Loai;
import com.example.websitebanquanao.infrastructures.responses.LoaiResponse;
import com.example.websitebanquanao.infrastructures.responses.ThuongHieuResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiRepository extends JpaRepository<Loai, Integer> {

    @Query("select new com.example.websitebanquanao.infrastructures.responses.LoaiResponse(m.id, m.ten, m.ngay_tao, m.ngay_sua, m.trang_thai) from Loai m where m.trang_thai = 1 ORDER BY m.ngay_tao desc ")
    public List<LoaiResponse> getAll();

    @Query("select new com.example.websitebanquanao.infrastructures.responses.LoaiResponse(m.id, m.ten, m.ngay_tao, m.ngay_sua, m.trang_thai) from Loai m ORDER BY CASE WHEN m.trang_thai = 1 THEN 0 ELSE 1 END, m.ngay_tao desc ")
    public Page<LoaiResponse> getPage(Pageable pageable);

    @Query("select new com.example.websitebanquanao.infrastructures.responses.LoaiResponse(m.id, m.ten ,m.ngay_tao,m.ngay_sua,m.trang_thai) from Loai m where m.id = :id")
    public LoaiResponse getByIdResponse(@Param("id") Integer id);

    boolean existsByTen(String ten);
}