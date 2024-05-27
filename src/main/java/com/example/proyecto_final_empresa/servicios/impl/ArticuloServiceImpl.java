package com.example.proyecto_final_empresa.servicios.impl;

import com.example.proyecto_final_empresa.dto.get.ArticuloGetDTO;
import com.example.proyecto_final_empresa.dto.get.TipoArticuloGetDTO;
import com.example.proyecto_final_empresa.modelo.Articulo;
import com.example.proyecto_final_empresa.modelo.TipoArticulo;
import com.example.proyecto_final_empresa.repositorio.ArticuloRepo;
import com.example.proyecto_final_empresa.servicios.interfaces.ArticuloService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticuloServiceImpl implements ArticuloService {

    private ArticuloRepo articuloRepo;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<ArticuloGetDTO> listarArticulos() throws Exception {
        List<Articulo> articulos = articuloRepo.findAll();
        List<ArticuloGetDTO> articulosGetDTO = new ArrayList<>();

        for (Articulo a : articulos) {
            articulosGetDTO.add(convertir(a));
        }

        return articulosGetDTO;
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Articulo buscar(int codigoArticulo) throws Exception {
        return articuloRepo.findById(codigoArticulo).get();
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public ArticuloGetDTO buscarDTO(int codigoArticulo) throws Exception {
        return convertir(buscar(codigoArticulo));
    }

    private ArticuloGetDTO convertir(Articulo articulo) {
        return new ArticuloGetDTO(
                articulo.getCodigoArticulo(),
                articulo.getNombre(),
                articulo.getPrecio(),
                articulo.getDescripcion(),
                convertirTipoArticulo(articulo.getTipoArticulo())
        );
    }

    private TipoArticuloGetDTO convertirTipoArticulo(TipoArticulo tipoArticulo) {
        return new TipoArticuloGetDTO(
                tipoArticulo.getCodigo(),
                tipoArticulo.getNombre(),
                tipoArticulo.getDescripcion()
        );
    }
}
