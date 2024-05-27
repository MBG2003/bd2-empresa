package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.get.AutomovilGetDTO;
import com.example.proyecto_final_empresa.dto.get.TipoAutomovilGetDTO;
import com.example.proyecto_final_empresa.dto.get.TipoGamaGetDTO;
import com.example.proyecto_final_empresa.dto.get.TipoMarcaAutoGetDTO;
import com.example.proyecto_final_empresa.modelo.Automovil;
import com.example.proyecto_final_empresa.modelo.TipoAutomovil;
import com.example.proyecto_final_empresa.modelo.TipoGama;
import com.example.proyecto_final_empresa.modelo.TipoMarcaAuto;
import com.example.proyecto_final_empresa.repositorio.AutomovilRepo;
import com.example.proyecto_final_empresa.servicios.interfaces.AutomovilService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AutomovilServiceImpl implements AutomovilService {

    private AutomovilRepo automovilRepo;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<AutomovilGetDTO> listarAutomoviles() throws Exception {
        List<Automovil> automoviles = automovilRepo.findAll();
        List<AutomovilGetDTO> automovilesGetDTO = new ArrayList<>();

        for (Automovil a : automoviles) {
            automovilesGetDTO.add(convertir(a));
        }

        return automovilesGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Automovil buscar(int codigoAutomovil) throws Exception {
        validar(codigoAutomovil);
        return automovilRepo.findById(codigoAutomovil).get();
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public AutomovilGetDTO buscarDTO(int codigoAutomovil) throws Exception {
        return convertir(buscar(codigoAutomovil));
    }

    private AutomovilGetDTO convertir(Automovil automovil) {
        return new AutomovilGetDTO(
                automovil.getCodigoAutomovil(),
                automovil.getNombre(),
                automovil.getCapacidadMax(),
                automovil.getEstado(),
                automovil.getDisponible(),
                automovil.getPrecio(),
                convertirTipoGama(automovil.getTipoGama())
        );
    }

    private TipoGamaGetDTO convertirTipoGama(TipoGama tipoGama) {
        return new TipoGamaGetDTO(
                tipoGama.getCodigoTipoGama(),
                tipoGama.getNombre(),
                tipoGama.getDescripcion(),
                convertirTipoAuto(tipoGama.getTipoAutomovil())
        );
    }

    private TipoAutomovilGetDTO convertirTipoAuto(TipoAutomovil tipoAutomovil) {
        return new TipoAutomovilGetDTO(
                tipoAutomovil.getCodigoTipoAutomovil(),
                tipoAutomovil.getNombre(),
                tipoAutomovil.getDescripcion(),
                convertirTipoMarca(tipoAutomovil.getTipoMarcaAuto())
        );
    }

    private TipoMarcaAutoGetDTO convertirTipoMarca(TipoMarcaAuto tipoMarcaAuto) {
        return new TipoMarcaAutoGetDTO(
                tipoMarcaAuto.getCodigoTipoMarcaAuto(),
                tipoMarcaAuto.getNombre(),
                tipoMarcaAuto.getDescripcion()
        );
    }

    private void validar(int codigoAutomovil) throws Exception {
        if(!automovilRepo.existsById(codigoAutomovil)) {
            throw new Exception("No se encontró el automóvil: " + codigoAutomovil);
        }
    }
}
