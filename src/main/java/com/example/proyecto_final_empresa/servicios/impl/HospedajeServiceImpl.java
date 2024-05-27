package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.get.*;
import com.example.proyecto_final_empresa.modelo.*;
import com.example.proyecto_final_empresa.repositorio.HospedajeRepo;
import com.example.proyecto_final_empresa.repositorio.InstalacionesRepo;
import com.example.proyecto_final_empresa.repositorio.TipoHospedajeRepo;
import com.example.proyecto_final_empresa.repositorio.TipoRegimenRepo;
import com.example.proyecto_final_empresa.servicios.interfaces.HabitacionService;
import com.example.proyecto_final_empresa.servicios.interfaces.HospedajeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HospedajeServiceImpl implements HospedajeService {

    private HospedajeRepo hospedajeRepo;

    private TipoRegimenRepo tipoRegimenRepo;

    private TipoHospedajeRepo tipoHospedajeRepo;

    private InstalacionesRepo instalacionesRepo;

    private HabitacionService habitacionService;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<TipoRegimenGetDTO> listarTipoRegimen() throws Exception {
        List<TiposRegimen> tiposRegimen = tipoRegimenRepo.findAll();
        List<TipoRegimenGetDTO> tiposRegimenGetDTO = new ArrayList<>();

        for (TiposRegimen tr : tiposRegimen) {
            tiposRegimenGetDTO.add(convertirTipoRegimen(tr));
        }

        return tiposRegimenGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<HospedajeGetDTO> listarHospedaje() throws Exception {
        System.out.println("consultando hospedajes");
        List<Hospedaje> hospedajes = hospedajeRepo.findAll();
        List<HospedajeGetDTO> hospedajeGetDTOS = new ArrayList<>();

        for (Hospedaje h: hospedajes) {
            hospedajeGetDTOS.add(convertir(h));

        }
        return hospedajeGetDTOS;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<HospedajeGetDTO> filtroInstalaciones(int codigoInstalaciones) throws Exception {
        List<Hospedaje> hospedajes = hospedajeRepo.filtroInstalaciones(codigoInstalaciones);
        List<HospedajeGetDTO> hospedajeGetDTOS = new ArrayList<>();

        for (Hospedaje h: hospedajes) {
            hospedajeGetDTOS.add(convertir(h));

        }
        return hospedajeGetDTOS;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<HospedajeGetDTO> filtroTipoHotel(int codigoTipoHotel) throws Exception {
        List<Hospedaje> hospedajes = hospedajeRepo.filtroTipoHotel(codigoTipoHotel);
        List<HospedajeGetDTO> hospedajeGetDTOS = new ArrayList<>();

        for (Hospedaje h: hospedajes) {
            hospedajeGetDTOS.add(convertir(h));

        }
        return hospedajeGetDTOS;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<HospedajeGetDTO> filtroPrecioMin(BigDecimal precioMin) throws Exception {
        List<Hospedaje> hospedajes = hospedajeRepo.filtroPrecioMin(precioMin);
        List<HospedajeGetDTO> hospedajeGetDTOS = new ArrayList<>();

        for (Hospedaje h: hospedajes) {
            hospedajeGetDTOS.add(convertir(h));

        }
        return hospedajeGetDTOS;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<HospedajeGetDTO> filtroPrecioMax(BigDecimal precioMax) throws Exception {
        List<Hospedaje> hospedajes = hospedajeRepo.filtroPrecioMax(precioMax);
        List<HospedajeGetDTO> hospedajeGetDTOS = new ArrayList<>();

        for (Hospedaje h: hospedajes) {
            hospedajeGetDTOS.add(convertir(h));

        }
        return hospedajeGetDTOS;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<HospedajeGetDTO> filtroRangoPrecio(BigDecimal precioMin, BigDecimal precioMax) throws Exception {
        List<Hospedaje> hospedajes = hospedajeRepo.filtroRangoPrecio(precioMin, precioMax);
        List<HospedajeGetDTO> hospedajeGetDTOS = new ArrayList<>();

        for (Hospedaje h: hospedajes) {
            hospedajeGetDTOS.add(convertir(h));

        }
        return hospedajeGetDTOS;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<TipoHospedajeGetDTO> listarTipoHospedaje() throws Exception {
        List<TipoHospedaje> tiposHospedaje = tipoHospedajeRepo.findAll();
        List<TipoHospedajeGetDTO> tiposHospedajeGetDTO = new ArrayList<>();

        for (TipoHospedaje th : tiposHospedaje) {
            tiposHospedajeGetDTO.add(convertirTipoHospedaje(th));
        }

        return tiposHospedajeGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<InstalacionesGetDTO> listarInstalaciones() throws Exception {
        List<Instalaciones> instalaciones = instalacionesRepo.findAll();
        List<InstalacionesGetDTO> instalacionesGetDTO = new ArrayList<>();

        for (Instalaciones inst : instalaciones) {
            instalacionesGetDTO.add(convertirInstalaciones(inst));
        }

        return instalacionesGetDTO;
    }

    private TipoRegimenHospedajeGetDTO convertirTipoRegimenHospedaje(TipoRegimenHospedaje tiposRegimenHospedaje) {
        return new TipoRegimenHospedajeGetDTO(
                tiposRegimenHospedaje.getCodigo(),
                tiposRegimenHospedaje.getPrecio(),
                convertirTipoRegimen(tiposRegimenHospedaje.getTiposRegimen())
        );
    }

    private TipoRegimenGetDTO convertirTipoRegimen(TiposRegimen tiposRegimen) {
        return new TipoRegimenGetDTO(
                tiposRegimen.getCodigoTipoRegimen(),
                tiposRegimen.getNombre(),
                tiposRegimen.getDescripcion()
        );
    }

    private HospedajeGetDTO convertir(Hospedaje hospedaje) throws Exception {

        List<TipoRegimenHospedajeGetDTO> tiposRegimen = new ArrayList<>();
        List<HabitacionGetDTO> habitaciones = new ArrayList<>();
        List<InstalacionesGetDTO> instalaciones = new ArrayList<>();

        for (TipoRegimenHospedaje trh : hospedaje.getTipoRegimenHospedajes()) {
            tiposRegimen.add(convertirTipoRegimenHospedaje(trh));
        }

        for (Habitacion h : hospedaje.getHabitaciones()) {
            habitaciones.add(habitacionService.buscarDTO(h.getCodigoHabitacion()));
        }

        for (Instalaciones i : hospedaje.getInstalaciones()) {
            instalaciones.add(convertirInstalaciones(i));
        }

        return new HospedajeGetDTO(
                hospedaje.getCodigoHospedaje(),
                convertirTipoHospedaje(hospedaje.getTipoHospedaje()),
                tiposRegimen,
                habitaciones,
                instalaciones
        );
    }

    private TipoHospedajeGetDTO convertirTipoHospedaje(TipoHospedaje tipoHospedaje) {
        return new TipoHospedajeGetDTO(
                tipoHospedaje.getCodigoTipoHospedaje(),
                tipoHospedaje.getNombre(),
                tipoHospedaje.getDescripcion()
        );
    }

    private InstalacionesGetDTO convertirInstalaciones(Instalaciones instalaciones) {
        return new InstalacionesGetDTO(
                instalaciones.getCodigoInstalaciones(),
                instalaciones.getNombre(),
                instalaciones.getDescripcion(),
                instalaciones.getEstado()
        );
    }
}
