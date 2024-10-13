package com.example.mag.aktuelapi.service;

import com.example.mag.aktuelapi.dto.mark.MarkDeleteDto;
import com.example.mag.aktuelapi.dto.mark.MarkDto;
import com.example.mag.aktuelapi.model.Mark;
import com.example.mag.aktuelapi.repository.MarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkService {


    private final MarkRepository markRepository;

    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public Mark getMarkId(Long id) throws Exception {
        Optional<Mark> mark = markRepository.findById(id);
        if (mark.isPresent()) {
            return mark.get();
        } else {
            throw new Exception("Id ye ait  bir mark bulunamadı");
        }
    }

    public List<Mark> findAll() {
        return markRepository.findAll();
    }

    public Mark create(MarkDto dto) {
        Mark mark = new Mark();
        mark.setName(dto.getName());
        mark.setLink(dto.getLink());
        markRepository.save(mark);
        return mark;
    }

    public Mark update(Long id, MarkDto dto) {
        return markRepository.findById(id).map(product -> {
            product.setName(dto.getName());
            product.setLink(dto.getLink());
            return markRepository.save(product);
        }).orElseThrow(() -> new RuntimeException("Mark not found"));
    }

    public void delete(Long id) {
        if (markRepository.existsById(id)) {
            markRepository.deleteById(id);
        } else {
            throw new RuntimeException("Kayıt bulunamadı");
        }
    }


}
