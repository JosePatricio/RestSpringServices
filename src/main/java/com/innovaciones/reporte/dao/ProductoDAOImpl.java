/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaciones.reporte.dao;

import com.innovaciones.reporte.model.DTO.ProductoDTO;
import com.innovaciones.reporte.model.Producto;
import com.innovaciones.reporte.util.CategoriasEnum;
import com.innovaciones.reporte.util.Enums;
import com.innovaciones.reporte.util.EstadosEnum;
import com.innovaciones.reporte.util.Utilities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fyaulema
 */
@Repository
public class ProductoDAOImpl extends Utilities implements ProductoDAO, Serializable {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Producto addProducto(Producto producto) {
        //sessionFactory.getCurrentSession().saveOrUpdate(producto);

        StringBuilder sb = new StringBuilder();
        StringBuilder sbQuery = new StringBuilder();
        SimpleDateFormat dateFormat = null;

        System.out.println("addProducto.precioSinIva:()" + producto.getPrecioSinIva());
        System.out.println("addProducto.precioIva:()" + producto.getPrecioIva());

        if (producto.getId() == null) {

            sbQuery.append("INSERT INTO `reportes_v2`.`producto` (");

            sb.append("\nVALUES(");

            if (producto.getIdCategoria() != null) {
                sbQuery.append("`id_categoria`");
                sb.append(producto.getIdCategoria().getId());
            }

            if (producto.getIdModelo() != null) {
                sbQuery.append(", ").append("`id_modelo`");
                sb.append(", ").append(producto.getIdModelo().getId());
            }

            if (producto.getIdMarca() != null) {
                sbQuery.append(", ").append("`id_marca`");
                sb.append(", ").append(producto.getIdMarca().getId());
            }

            if (producto.getIdPadre() != null) {
                sbQuery.append(", ").append("`id_padre`");
                sb.append(", ").append(producto.getIdPadre());
            }

            if (producto.getIdAncestro() != null) {
                sbQuery.append(", ").append("`id_ancestro`");
                sb.append(", ").append(producto.getIdAncestro());
            }

            if (producto.getIdUnidadMedida() != null) {
                sbQuery.append(", ").append("`id_unidad_medida`");
                sb.append(", ").append(producto.getIdUnidadMedida().getId());
            }

            if (producto.getCodigoFabricante() != null && !producto.getCodigoFabricante().isEmpty()) {
                sbQuery.append(", ").append("`codigo_fabricante`");
                sb.append(", '").append(producto.getCodigoFabricante()).append("' ");
            }

            if (producto.getCodigoAnterior() != null && !producto.getCodigoAnterior().isEmpty()) {
                sbQuery.append(", ").append("`codigo_anterior`");
                sb.append(", '").append(producto.getCodigoAnterior()).append("' ");
            }

            if (producto.getCodigoAncestro() != null && !producto.getCodigoAncestro().isEmpty()) {
                sbQuery.append(", ").append("`codigo_ancestro`");
                sb.append(", '").append(producto.getCodigoAncestro()).append("' ");
            }

            if (producto.getCodigoInterno() != null && !producto.getCodigoInterno().isEmpty()) {
                sbQuery.append(", ").append("`codigo_interno`");
                sb.append(", '").append(producto.getCodigoInterno()).append("' ");
            }

            if (producto.getCodigoBarras() != null && !producto.getCodigoBarras().isEmpty()) {
                sbQuery.append(", ").append("`codigo_barras`");
                sb.append(", '").append(producto.getCodigoBarras()).append("' ");
            }

            /*  if (producto.getEquipo() != null && !producto.getEquipo().isEmpty()) {
                sbQuery.append(", ").append("`equipo`");
                sb.append(", '").append(producto.getEquipo()).append("' ");
            }
             */
            if (producto.getVersionFirmware() != null && !producto.getVersionFirmware().isEmpty()) {
                sbQuery.append(", ").append("`version_firmware`");
                sb.append(", '").append(producto.getVersionFirmware()).append("' ");
            }

            if (producto.getCampo1() != null && !producto.getCampo1().isEmpty()) {
                sbQuery.append(", ").append("`campo_1`");
                sb.append(", '").append(producto.getCampo1()).append("' ");
            }

            if (producto.getCampo2() != null && !producto.getCampo2().isEmpty()) {
                sbQuery.append(", ").append("`campo_2`");
                sb.append(", '").append(producto.getCampo2()).append("' ");
            }

            sbQuery.append(", ").append("`estado`");
            sb.append(", ").append(producto.getEstado());

            if (producto.getFechaRegistro() != null) {
                dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaRegistro = dateFormat.format(producto.getFechaRegistro());
                sbQuery.append(", ").append("`fecha_registro`");
                sb.append(", '").append(fechaRegistro).append("' ");
            }

            sbQuery.append(", ").append("`id_usuario_registro`");
            sb.append(", ").append(producto.getIdUsuarioRegistro());

            if (producto.getFechaModificacion() != null) {
                dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaModificacion = dateFormat.format(producto.getFechaModificacion());
                sbQuery.append(", ").append("`fecha_modificacion`");
                sb.append(", '").append(fechaModificacion).append("' ");
            }

            if (producto.getIdUsuarioModicacion() != null) {
                sbQuery.append(", ").append("`id_usuario_modicacion`");
                sb.append(", ").append(producto.getIdUsuarioModicacion());
            }

            sbQuery.append(", ").append("`requiere_serial`");
            sb.append(", ").append(producto.getRequiereSerial());

            if (producto.getDescripcionCompra() != null && !producto.getDescripcionCompra().isEmpty()) {
                sbQuery.append(", ").append("`descripcion_compra`");
                sb.append(", '").append(producto.getDescripcionCompra()).append("' ");
            }
            if (producto.getDescripcionVenta() != null && !producto.getDescripcionVenta().isEmpty()) {
                sbQuery.append(", ").append("`descripcion_venta`");
                sb.append(", '").append(producto.getDescripcionVenta()).append("' ");
            }
            if (producto.getStockMinimo() != null) {
                sbQuery.append(", ").append("`stock_minimo`");
                sb.append(", ").append(producto.getStockMinimo());
            }
            if (producto.getStockMaximo() != null) {
                sbQuery.append(", ").append("`stock_maximo`");
                sb.append(", ").append(producto.getStockMaximo());
            }

            if (producto.getIdProveedorPreferido() != null) {
                sbQuery.append(", ").append("`id_proveedor_preferido`");
                sb.append(", ").append(producto.getIdProveedorPreferido());
            }

            if (producto.getStockActual() != null) {
                sbQuery.append(", ").append("`stock_actual`");
                sb.append(", ").append(producto.getStockActual());
            }

            if (producto.getIdTipoProducto() != null) {
                sbQuery.append(", ").append("`id_tipo_producto`");
                sb.append(", ").append(producto.getIdTipoProducto().getId());
            }

            if (producto.getPrecioSinIva() != null) {
                sbQuery.append(", ").append("`precio_sin_iva`");
                sb.append(", ").append(producto.getPrecioSinIva().toString());
            }

            if (producto.getPrecioIva() != null) {
                sbQuery.append(", ").append("`precio_iva`");
                sb.append(", ").append(producto.getPrecioIva().toString());
            }

            if (producto.getPrecioDistribuidor() != null) {
                sbQuery.append(", ").append("`precio_distribuidor`");
                sb.append(", ").append(producto.getPrecioDistribuidor().toString());
            }

            if (producto.getPrecioMayorista() != null) {
                sbQuery.append(", ").append("`precio_mayorista`");
                sb.append(", ").append(producto.getPrecioMayorista().toString());
            }

            if (producto.getPrecioCanal() != null) {
                sbQuery.append(", ").append("`precio_canal`");
                sb.append(", ").append(producto.getPrecioCanal().toString());
            }

            if (producto.getPrecioMegaCanal() != null) {
                sbQuery.append(", ").append("`precio_mega_canal`");
                sb.append(", ").append(producto.getPrecioMegaCanal().toString());
            }
            /////////////////////
            if (producto.getCicloMantenimiento() != null) {
                sbQuery.append(", ").append("`is_ciclo_mantenimiento`");
                sb.append(", ").append(producto.getCicloMantenimiento().toString());
            }

            if (producto.getVidaUtil() != null) {
                sbQuery.append(", ").append("`vida_util`");
                sb.append(", ").append(producto.getVidaUtil().toString());
            }

            if (producto.getRendimientoFabrica() != null) {
                sbQuery.append(", ").append("`rendimiento_fabrica`");
                sb.append(", ").append(producto.getRendimientoFabrica().toString());
            }

            if (producto.getRendimientoReal() != null) {
                sbQuery.append(", ").append("`rendimiento_real`");
                sb.append(", ").append(producto.getRendimientoReal().toString());
            }

            if (producto.getRendimientoExtendido() != null) {
                sbQuery.append(", ").append("`rendimiento_extendido`");
                sb.append(", ").append(producto.getRendimientoExtendido().toString());
            }

            StringBuilder idStringBuilder = new StringBuilder();
            idStringBuilder.append("SELECT `AUTO_INCREMENT` ");
            idStringBuilder.append("FROM  INFORMATION_SCHEMA.TABLES ");
            idStringBuilder.append("WHERE TABLE_SCHEMA = 'reportes_v2' AND TABLE_NAME = 'producto';");

            BigInteger id = (BigInteger) sessionFactory.getCurrentSession().createSQLQuery(idStringBuilder.toString()).uniqueResult();

            sbQuery.append(", ").append("`id`");
            sb.append(", ").append(id.intValue());

            sbQuery.append(" )");
            sb.append(");");
            sbQuery.append(sb.toString());

            Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());
            query.executeUpdate();
            producto.setId(id.intValue());

        } else {

            sbQuery.append("UPDATE `reportes_v2`.`producto` ");
            sbQuery.append("SET ");

            sbQuery.append("`id` = ").append(producto.getId());

            if (producto.getIdMarca() != null) {
                sbQuery.append(",`id_marca` = ").append(producto.getIdMarca().getId());
            }

            if (producto.getIdModelo() != null) {
                sbQuery.append(",`id_modelo` = ").append(producto.getIdModelo().getId());
            }

            if (producto.getIdCategoria() != null) {
                sbQuery.append(",`id_categoria` = ").append(producto.getIdCategoria().getId());
            }

            if (producto.getIdPadre() != null) {
                sbQuery.append(",`id_padre` = ").append(producto.getIdPadre());
            }

            if (producto.getIdAncestro() != null) {
                sbQuery.append(",`id_ancestro` = ").append(producto.getIdAncestro());
            }

            if (producto.getIdUnidadMedida() != null) {
                sbQuery.append(",`id_unidad_medida` = ").append(producto.getIdUnidadMedida().getId());
            }

            if (producto.getCodigoFabricante() != null) {
                sbQuery.append(",`codigo_fabricante` = '").append(producto.getCodigoFabricante()).append("'");
            }

            if (producto.getCodigoAnterior() != null) {

                sbQuery.append(",`codigo_anterior` = '").append(producto.getCodigoAnterior()).append("'");
            }

            if (producto.getCodigoAncestro() != null) {
                sbQuery.append(",`codigo_ancestro` = '").append(producto.getCodigoAncestro()).append("'");
            }

            if (producto.getCodigoInterno() != null) {
                sbQuery.append(",`codigo_interno` = '").append(producto.getCodigoInterno()).append("'");
            }

            if (producto.getCodigoBarras() != null) {
                sbQuery.append(",`codigo_barras` = '").append(producto.getCodigoBarras()).append("'");
            }
            // sbQuery.append(",`equipo` = '").append(producto.getEquipo()).append("'");

            if (producto.getVersionFirmware() != null) {
                sbQuery.append(",`version_firmware` = '").append(producto.getVersionFirmware()).append("'");
            }

            if (producto.getCampo1() != null) {
                sbQuery.append(",`campo_1` = '").append(producto.getCampo1()).append("'");
            }
            if (producto.getCampo2() != null) {
                sbQuery.append(",`campo_2` = '").append(producto.getCampo2()).append("'");
            }

            sbQuery.append(",`estado` = ").append(producto.getEstado());

            if (producto.getFechaRegistro() != null) {
                dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaRegistro = dateFormat.format(producto.getFechaRegistro());
                sbQuery.append(",`fecha_registro` = '").append(fechaRegistro).append("'");
            }

            sbQuery.append(",`id_usuario_registro` = ").append(producto.getIdUsuarioRegistro());

            if (producto.getFechaRegistro() != null) {
                dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaModificacion = dateFormat.format(producto.getFechaRegistro());
                sbQuery.append(",`fecha_modificacion` = '").append(fechaModificacion).append("'");
            }

            if (producto.getIdUsuarioModicacion() != null) {
                sbQuery.append(",`id_usuario_modicacion` = ").append(producto.getIdUsuarioModicacion());
            }

            sbQuery.append(",`requiere_serial` = ").append(producto.getRequiereSerial());

            if (producto.getDescripcionCompra() != null) {
                sbQuery.append(",`descripcion_compra` = '").append(producto.getDescripcionCompra()).append("'");
            }

            if (producto.getDescripcionVenta() != null) {
                sbQuery.append(",`descripcion_venta` = '").append(producto.getDescripcionVenta()).append("'");
            }

            if (producto.getStockMinimo() != null) {
                sbQuery.append(",`stock_minimo` = ").append(producto.getStockMinimo());
            }

            if (producto.getStockMaximo() != null) {
                sbQuery.append(",`stock_maximo` = ").append(producto.getStockMaximo());
            }

            if (producto.getIdProveedorPreferido() != null) {
                sbQuery.append(",`id_proveedor_preferido` = ").append(producto.getIdProveedorPreferido().getId());
            }

            if (producto.getStockActual() != null) {
                sbQuery.append(",`stock_actual` = ").append(producto.getStockActual());
            }

            if (producto.getIdTipoProducto() != null) {
                sbQuery.append(",`id_tipo_producto` = ").append(producto.getIdTipoProducto().getId());
            }

            if (producto.getPrecioSinIva() != null) {
                sbQuery.append(", ").append("`precio_sin_iva`=").append(producto.getPrecioSinIva().toString());
            }

            if (producto.getPrecioIva() != null) {
                sbQuery.append(", ").append("`precio_iva`=").append(producto.getPrecioIva().toString());
            }

            if (producto.getPrecioDistribuidor() != null) {
                sbQuery.append(", ").append("`precio_distribuidor`=").append(producto.getPrecioDistribuidor().toString());
            }

            if (producto.getPrecioMayorista() != null) {
                sbQuery.append(", ").append("`precio_mayorista`=").append(producto.getPrecioMayorista().toString());
            }

            if (producto.getPrecioCanal() != null) {
                sbQuery.append(", ").append("`precio_canal`=").append(producto.getPrecioCanal().toString());
            }

            if (producto.getPrecioMegaCanal() != null) {
                sbQuery.append(", ").append("`precio_mega_canal`=").append(producto.getPrecioMegaCanal().toString());
            }
            ////////////////////

            if (producto.getCicloMantenimiento() != null) {
                sbQuery.append(", ").append("`is_ciclo_mantenimiento`=").append(producto.getCicloMantenimiento().toString());
            }

            if (producto.getVidaUtil() != null) {
                sbQuery.append(", ").append("`vida_util`=").append(producto.getVidaUtil().toString());
            }

            if (producto.getRendimientoFabrica() != null) {
                sbQuery.append(", ").append("`rendimiento_fabrica`=").append(producto.getRendimientoFabrica().toString());
            }

            if (producto.getRendimientoReal() != null) {
                sbQuery.append(", ").append("`rendimiento_real`=").append(producto.getRendimientoReal().toString());
            }

            if (producto.getRendimientoExtendido() != null) {
                sbQuery.append(", ").append("`rendimiento_extendido`=").append(producto.getRendimientoExtendido().toString());
            }

            sbQuery.append(" WHERE `id` =").append(producto.getId());

            System.out.println("ProductoDAOImpl.addProducto(): " + sbQuery.toString());
            Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());
            query.executeUpdate();
        }
        return producto;
    }

    @Override
    public List<ProductoDTO> getProductosDTOStockByEstado(Integer idBodega, Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT p.id, p.id_padre, UPPER(p.codigo_fabricante), UPPER(p.codigo_anterior), UPPER(p.codigo_interno), c.id id_categoria, ");
        sbQuery.append("UPPER(c.nombre) categoria, ma.id id_marca, UPPER(ma.marca), mo.id id_modelo, UPPER(mo.modelo),");
        sbQuery.append("UPPER(p.descripcion_compra), UPPER(p.descripcion_venta) , p.equipo, p.campo_1, p.campo_2, p.fecha_registro, p.id_usuario_registro, ");
        sbQuery.append("p.fecha_modificacion, p.id_usuario_modicacion, p.estado, count(dip.id) stock, UPPER(t.nombre), UPPER(ma.codigo) codigo_marca, ");
        sbQuery.append("UPPER(c.codigo) codigo_categoria, p.tiene_compatible, UPPER(um.nombre) unidad_medida, p.requiere_serial, UPPER(b.nombre) bodega, ");
        sbQuery.append("UPPER(upb.mueble), UPPER(upb.cajon), UPPER(upb.espacio), p.stock_minimo, p.stock_maximo, ");
        sbQuery.append("  UPPER((SELECT GROUP_CONCAT(modelo.modelo) from modelo ");
        sbQuery.append("   INNER JOIN producto_modelo ON modelo.id = producto_modelo.id_modelo ");
        sbQuery.append("   WHERE p.id = id_producto and producto_modelo.estado =:estado)) compatibles, p.codigo_barras, dcr.descripcion, ");

        sbQuery.append("p.precio_sin_iva, precio_iva, p.precio_distribuidor, ");
        sbQuery.append("p.precio_mayorista, p.precio_canal, p.precio_mega_canal, ");
        sbQuery.append("p.is_ciclo_mantenimiento, p.vida_util, p.rendimiento_fabrica, ");
        sbQuery.append("p.rendimiento_real, p.rendimiento_extendido ");

        sbQuery.append("FROM producto p ");
        sbQuery.append("INNER JOIN categoria c ON c.id = p.id_categoria ");
        sbQuery.append("INNER JOIN tipo_producto t ON t.id = p.id_tipo_producto ");
        sbQuery.append("INNER JOIN unidad_medida um ON um.id = p.id_unidad_medida ");
        sbQuery.append("LEFT  JOIN modelo mo ON mo.id = p.id_modelo ");
        sbQuery.append("LEFT  JOIN marca ma ON ma.id = p.id_marca ");
        sbQuery.append("LEFT  JOIN ubicacion_producto_bodega upb ON upb.id_producto =  p.id ");
        sbQuery.append("LEFT  JOIN producto_repuesto_reporte prr ON prr.id_producto = p.id ");
        sbQuery.append("LEFT  JOIN detalle_catalogo_reporte dcr ON prr.id_detalle_catalogo_reporte = dcr.id ");
        sbQuery.append("LEFT  JOIN bodega b ON b.id =  upb.id_bodega ");
        sbQuery.append("LEFT  JOIN detalle_inventario di ON p.id = di.id_producto ");
        sbQuery.append("LEFT  JOIN cabecera_inventario ce ON ce.id = di.id_cabecera_inventario ");
        sbQuery.append("LEFT  JOIN detalle_inventario_producto dip ON dip.id_detalle_inventario = di.id ");
        sbQuery.append("AND dip.estado = :estado ");
        sbQuery.append("AND dip.estado_proceso <>:estadoReservado ");
        sbQuery.append("AND dip.estado_proceso <>:estadoDespachado ");

        if (idBodega != null) {
            sbQuery.append(" AND dip.id_bodega=:idBodega ");
        }

        if (estado != null) {
            sbQuery.append("WHERE p.estado =:estado ");
        }
        sbQuery.append("GROUP BY p.id ");
        sbQuery.append("ORDER BY estado DESC, codigo_fabricante ");

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());
        query.setParameter("estadoReservado", Enums.ESTADO_PROCESO_RESERVADO.getValue());
        query.setParameter("estadoDespachado", Enums.ESTADO_PROCESO_DESPACHADO.getValue());

        if (idBodega != null) {
            query.setParameter("idBodega", idBodega);
        }

        if (estado == null) {
            estado = EstadosEnum.ACTIVO.getValue();
        }

        query.setParameter("estado", estado);

//        System.out.println("idBodega(): " + idBodega + "   estado(): " + estado);
//        System.out.println("SQL(): " + sbQuery.toString());
        List<Object[]> resultObject = (List<Object[]>) query.list();
        List<ProductoDTO> result = new ArrayList<>();

        for (Object[] object : resultObject) {

            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setId(object[0] != null ? Integer.parseInt(object[0].toString()) : null);
            productoDTO.setIdPadre(object[1] != null ? Integer.parseInt(object[1].toString()) : null);
            productoDTO.setCodigoFabricante(object[2] != null ? object[2].toString() : null);
            productoDTO.setCodigoAnterior(object[3] != null ? object[3].toString() : null);
            productoDTO.setCodigoInterno(object[4] != null ? object[4].toString() : null);

            productoDTO.setIdCategoria(object[5] != null ? Integer.parseInt(object[5].toString()) : null);
            productoDTO.setNombreCategoria(object[6] != null ? object[6].toString() : "--");
            productoDTO.setIdMarca(object[7] != null ? Integer.parseInt(object[7].toString()) : null);
            productoDTO.setNombreMarca(object[8] != null ? object[8].toString() : "--");
            productoDTO.setIdModelo(object[9] != null ? Integer.parseInt(object[9].toString()) : null);
            productoDTO.setNombreModelo(object[10] != null ? object[10].toString() : "--");

            productoDTO.setDescripcionCompra(object[11] != null ? object[11].toString() : null);
            productoDTO.setDescripcionVenta(object[12] != null ? object[12].toString() : null);
            productoDTO.setEquipo(object[13] != null ? object[13].toString() : null);

            productoDTO.setCampo1(object[14] != null ? object[14].toString() : null);
            productoDTO.setCampo2(object[15] != null ? object[15].toString() : null);

            productoDTO.setFechaRegistro(object[16] != null ? convertirToDate(object[16].toString()) : null);
            productoDTO.setIdUsuarioRegistro(object[17] != null ? Integer.parseInt(object[17].toString()) : null);

            productoDTO.setFechaModificacion(object[18] != null ? convertirToDate(object[18].toString()) : null);
            productoDTO.setIdUsuarioModificacion(object[19] != null ? Integer.parseInt(object[19].toString()) : null);

            productoDTO.setEstado(object[20] != null ? Integer.parseInt(object[20].toString()) : null);

            productoDTO.setStock(object[21] != null ? Integer.parseInt(object[21].toString()) : null);

            productoDTO.setTipo(object[22] != null ? object[22].toString() : "--");

            productoDTO.setCodigoMarca(object[23] != null ? object[23].toString() : "--");

            productoDTO.setCodigoCategoria(object[24] != null ? object[24].toString() : "--");

            productoDTO.setCompatibleObligatorio(object[25] != null ? "true".equalsIgnoreCase(object[25].toString()) ? "SI" : "NO" : "NO");

            productoDTO.setUnidadMedida(object[26] != null ? object[26].toString() : "--");

            productoDTO.setSerialObligatorio(object[27] != null ? "true".equalsIgnoreCase(object[27].toString()) ? "SI" : "NO" : "NO");

            productoDTO.setNombreBodega(object[28] != null ? object[28].toString() : "--");
            productoDTO.setMueble(object[29] != null ? object[29].toString() : "--");
            productoDTO.setCajon(object[30] != null ? object[30].toString() : "--");
            productoDTO.setEspacio(object[31] != null ? object[31].toString() : "--");

            productoDTO.setStockMinimo(object[32] != null ? Integer.parseInt(object[32].toString()) : null);
            productoDTO.setStockMaximo(object[33] != null ? Integer.parseInt(object[33].toString()) : null);

            productoDTO.setModelosCompatibles(object[34] != null ? object[34].toString() : null);
            productoDTO.setCodigoBarras(object[35] != null ? object[35].toString() : null);
            productoDTO.setNombreProductoEnReporte(object[36] != null ? object[36].toString() : null);

            productoDTO.setPrecioSinIva(object[37] != null ? new BigDecimal(object[37].toString()) : null);
            productoDTO.setPrecioIva(object[38] != null ? new BigDecimal(object[38].toString()) : null);
            productoDTO.setPrecioDistribuidor(object[39] != null ? new BigDecimal(object[39].toString()) : null);
            productoDTO.setPrecioMayorista(object[40] != null ? new BigDecimal(object[40].toString()) : null);
            productoDTO.setPrecioCanal(object[41] != null ? new BigDecimal(object[41].toString()) : null);
            productoDTO.setPrecioMegaCanal(object[42] != null ? new BigDecimal(object[42].toString()) : null);

            productoDTO.setCicloMantenimiento(object[43] != null ? "true".equalsIgnoreCase(object[43].toString()) ? "SI" : "NO" : "NO");

            productoDTO.setVidaUtil(object[44] != null ? Integer.parseInt(object[44].toString()) : null);
            productoDTO.setRendimientoFabrica(object[45] != null ? Integer.parseInt(object[45].toString()) : null);
            productoDTO.setRendimientoReal(object[46] != null ? Integer.parseInt(object[46].toString()) : null);
            productoDTO.setRendimientoExtendido(object[47] != null ? Integer.parseInt(object[47].toString()) : null);
            
            result.add(productoDTO);

            // System.out.println("getProductosDTOStockByEstado(): " + productoDTO.toString());
        }
        return result;
    }

    private List<ProductoDTO> cargarResultToList(List<Object[]> queryResult) {
        List<ProductoDTO> result = new ArrayList<>();

        for (Object[] object : queryResult) {

            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setId(object[0] != null ? Integer.parseInt(object[0].toString()) : null);
            productoDTO.setIdPadre(object[1] != null ? Integer.parseInt(object[1].toString()) : null);
            productoDTO.setCodigoFabricante(object[2] != null ? object[2].toString() : null);
            productoDTO.setCodigoAnterior(object[3] != null ? object[3].toString() : null);
            productoDTO.setCodigoInterno(object[4] != null ? object[4].toString() : null);

            productoDTO.setIdCategoria(object[5] != null ? Integer.parseInt(object[5].toString()) : null);
            productoDTO.setNombreCategoria(object[6] != null ? object[6].toString() : "--");
            productoDTO.setIdMarca(object[7] != null ? Integer.parseInt(object[7].toString()) : null);
            productoDTO.setNombreMarca(object[8] != null ? object[8].toString() : "--");
            productoDTO.setIdModelo(object[9] != null ? Integer.parseInt(object[9].toString()) : null);
            productoDTO.setNombreModelo(object[10] != null ? object[10].toString() : "--");

            productoDTO.setDescripcionCompra(object[11] != null ? object[11].toString() : null);
            productoDTO.setDescripcionVenta(object[12] != null ? object[12].toString() : null);
            productoDTO.setEquipo(object[13] != null ? object[13].toString() : null);

            productoDTO.setCampo1(object[14] != null ? object[14].toString() : null);
            productoDTO.setCampo2(object[15] != null ? object[15].toString() : null);

            productoDTO.setFechaRegistro(object[16] != null ? convertirToDate(object[16].toString()) : null);
            productoDTO.setIdUsuarioRegistro(object[17] != null ? Integer.parseInt(object[17].toString()) : null);

            productoDTO.setFechaModificacion(object[18] != null ? convertirToDate(object[18].toString()) : null);
            productoDTO.setIdUsuarioModificacion(object[19] != null ? Integer.parseInt(object[19].toString()) : null);

            productoDTO.setEstado(object[20] != null ? Integer.parseInt(object[20].toString()) : null);

            productoDTO.setStock(object[21] != null ? Integer.parseInt(object[21].toString()) : null);

            productoDTO.setTipo(object[22] != null ? object[22].toString() : "--");

//            System.out.println("com.innovaciones.reporte.dao.ProductoDAOImpl.getProductosDTOByIdCabeceraInventario(): " + object[23]);
            productoDTO.setSerialObligatorio(object[23] != null ? "true".equalsIgnoreCase(object[23].toString()) ? "SI" : "NO" : "NO");

            productoDTO.setSerial(object[24] != null ? object[24].toString() : "--");

            productoDTO.setIdBodega(object[25] != null ? Integer.parseInt(object[25].toString()) : null);

            productoDTO.setCodigoBodega(object[26] != null ? object[26].toString() : null);

            productoDTO.setNombreBodega(object[27] != null ? object[27].toString() : null);

            productoDTO.setEstadoProceso(object[28] != null ? object[28].toString() : null);

            productoDTO.setCodigoMarca(object[29] != null ? object[29].toString() : "--");

            productoDTO.setCodigoCategoria(object[30] != null ? object[30].toString() : "--");

            productoDTO.setCompatibleObligatorio(object[31] != null ? "true".equalsIgnoreCase(object[31].toString()) ? "SI" : "NO" : "NO");

            productoDTO.setUnidadMedida(object[32] != null ? object[32].toString() : "--");

            productoDTO.setStockMinimo(object[33] != null ? Integer.parseInt(object[33].toString()) : null);
            productoDTO.setStockMaximo(object[34] != null ? Integer.parseInt(object[34].toString()) : null);

            productoDTO.setModelosCompatibles(object[35] != null ? object[35].toString() : null);
            productoDTO.setCodigoBarras(object[36] != null ? object[36].toString() : null);

            result.add(productoDTO);

//            System.out.println("getProductosDTO(): " + productoDTO.toString());
        }
        return result;
    }

    @Override
    public List<ProductoDTO> getDetalleProductosDTOByIdCabeceraInventario(Integer idCabeceraInventario, Integer estado) {

        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT p.id id_producto, p.id_padre, UPPER(p.codigo_fabricante), p.codigo_anterior, p.codigo_interno, c.id id_categoria, c.nombre categoria, ma.id id_marca, ma.marca, ");
        sbQuery.append("mo.id id_modelo, mo.modelo, UPPER(p.descripcion_compra), UPPER(p.descripcion_venta), p.equipo, p.campo_1, p.campo_2, p.fecha_registro, p.id_usuario_registro, ");
        sbQuery.append("p.fecha_modificacion, p.id_usuario_modicacion, p.estado, 1 count, t.nombre, p.requiere_serial, dip.serial, b.id id_bodega, UPPER(b.codigo), UPPER(b.nombre), dip.estado_proceso, ");
        sbQuery.append("ma.codigo codigo_marca, c.codigo codigo_categoria, p.tiene_compatible, um.nombre unidad_medida,  p.stock_minimo, p.stock_maximo, ");
        sbQuery.append("  (SELECT GROUP_CONCAT(modelo.modelo) from modelo ");
        sbQuery.append("   INNER JOIN producto_modelo ON modelo.id = producto_modelo.id_modelo ");
        sbQuery.append("   WHERE p.id = id_producto) compatibles, p.codigo_barras ");
        sbQuery.append("FROM cabecera_inventario cab ");
        sbQuery.append("INNER JOIN detalle_inventario d ON cab.id = d.id_cabecera_inventario ");
        sbQuery.append("INNER JOIN detalle_inventario_producto dip ON d.id = dip.id_detalle_inventario ");
        sbQuery.append("INNER JOIN bodega b ON  b.id = dip.id_bodega ");
        sbQuery.append("INNER JOIN producto p ON d.id_producto = p.id ");
        sbQuery.append("INNER JOIN unidad_medida um ON um.id = p.id_unidad_medida ");
        sbQuery.append("INNER JOIN categoria c ON p.id_categoria = c.id ");
        sbQuery.append("INNER JOIN tipo_producto t ON t.id = p.id_tipo_producto ");
        sbQuery.append("LEFT  JOIN modelo mo ON  mo.id = p.id_modelo ");
        sbQuery.append("LEFT  JOIN marca ma ON  ma.id = p.id_marca ");
        sbQuery.append("WHERE cab.id=:idCabeceraInventario AND cab.estado =:estado AND d.estado = 1 AND p.requiere_serial = 1 AND dip.estado =1 ");
        sbQuery.append("UNION ");
        sbQuery.append("SELECT p.id id_producto, p.id_padre, UPPER(p.codigo_fabricante) , p.codigo_anterior, p.codigo_interno, c.id id_categoria, c.nombre categoria, ma.id id_marca, ma.marca, ");
        sbQuery.append("mo.id id_modelo, mo.modelo, UPPER(p.descripcion_compra), UPPER(p.descripcion_venta), p.equipo, p.campo_1, p.campo_2, p.fecha_registro, p.id_usuario_registro, ");
        sbQuery.append("p.fecha_modificacion, p.id_usuario_modicacion, p.estado, COUNT(p.id) count, t.nombre, p.requiere_serial, dip.serial, b.id id_bodega, UPPER(b.codigo), UPPER(b.nombre), dip.estado_proceso, ");
        sbQuery.append("ma.codigo codigo_marca, c.codigo codigo_categoria, p.tiene_compatible, um.nombre unidad_medida, p.stock_minimo, p.stock_maximo, ");
        sbQuery.append("  (SELECT GROUP_CONCAT(modelo.modelo) from modelo ");
        sbQuery.append("   INNER JOIN producto_modelo ON modelo.id = producto_modelo.id_modelo ");
        sbQuery.append("   WHERE p.id = id_producto) compatibles, p.codigo_barras ");
        sbQuery.append("FROM cabecera_inventario cab ");
        sbQuery.append("INNER JOIN detalle_inventario d ON cab.id = d.id_cabecera_inventario ");
        sbQuery.append("INNER JOIN detalle_inventario_producto dip ON d.id = dip.id_detalle_inventario ");
        sbQuery.append("INNER JOIN bodega b ON  b.id = dip.id_bodega ");
        sbQuery.append("INNER JOIN producto p ON d.id_producto = p.id ");
        sbQuery.append("INNER JOIN unidad_medida um ON um.id = p.id_unidad_medida ");
        sbQuery.append("INNER JOIN categoria c ON p.id_categoria = c.id ");
        sbQuery.append("INNER JOIN tipo_producto t ON t.id = p.id_tipo_producto ");
        sbQuery.append("LEFT  JOIN modelo mo ON  mo.id = p.id_modelo ");
        sbQuery.append("LEFT  JOIN marca ma ON  ma.id = p.id_marca ");
        sbQuery.append("WHERE cab.id=:idCabeceraInventario AND cab.estado =:estado AND d.estado = 1 AND p.requiere_serial = 0 AND dip.estado =1 ");
        sbQuery.append("GROUP BY  p.id ");

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());
        query.setParameter("idCabeceraInventario", idCabeceraInventario);
        query.setParameter("estado", estado);

//        System.out.println("SQL(): " + sbQuery.toString());
        List<Object[]> resultObject = (List<Object[]>) query.list();

        return cargarResultToList(resultObject);
    }

    @Override
    public List<ProductoDTO> getSolicitudProductosDTOByIdCabeceraInventario(Integer idCabeceraInventario, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append("SELECT p.id id_producto, p.id_padre, UPPER(p.codigo_fabricante), p.codigo_anterior, p.codigo_interno, c.id id_categoria, c.nombre categoria, ma.id id_marca, ma.marca, ");
        sbQuery.append("mo.id id_modelo, mo.modelo, p.descripcion_compra, UPPER(p.descripcion_venta) , p.equipo, p.campo_1, p.campo_2, p.fecha_registro, p.id_usuario_registro, ");
        sbQuery.append("p.fecha_modificacion, p.id_usuario_modicacion, p.estado, d.cantidad count, t.nombre, p.requiere_serial, '' serial , b.id, UPPER(b.codigo), UPPER(b.nombre), '' estado_proceso, ");
        sbQuery.append("ma.codigo codigo_marca, c.codigo codigo_categoria, p.tiene_compatible, um.nombre unidad_medida, p.stock_minimo, p.stock_maximo, ");
        sbQuery.append("  (SELECT GROUP_CONCAT(modelo.modelo) from modelo ");
        sbQuery.append("   INNER JOIN producto_modelo ON modelo.id = producto_modelo.id_modelo ");
        sbQuery.append("   WHERE p.id = id_producto) compatibles, p.codigo_barras ");
        sbQuery.append("FROM cabecera_inventario cab ");
        sbQuery.append("INNER JOIN detalle_inventario d ON cab.id = d.id_cabecera_inventario ");
        sbQuery.append("INNER JOIN bodega b ON  b.id = cab.id_bodega ");
        sbQuery.append("INNER JOIN producto p ON d.id_producto = p.id ");
        sbQuery.append("INNER JOIN unidad_medida um ON um.id = p.id_unidad_medida ");
        sbQuery.append("INNER JOIN categoria c ON p.id_categoria = c.id ");
        sbQuery.append("INNER JOIN tipo_producto t ON t.id = p.id_tipo_producto ");
        sbQuery.append("LEFT  JOIN modelo mo ON  mo.id = p.id_modelo ");
        sbQuery.append("LEFT  JOIN marca ma ON  ma.id = p.id_marca ");
        sbQuery.append("WHERE cab.id=:idCabeceraInventario AND cab.estado =:estado AND d.estado = 1 ");
        sbQuery.append("GROUP BY  p.id ");
        Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());
        query.setParameter("idCabeceraInventario", idCabeceraInventario);
        query.setParameter("estado", estado);

//        System.out.println("SQL(): " + sbQuery.toString());
        List<Object[]> resultObject = (List<Object[]>) query.list();

        return cargarResultToList(resultObject);
    }

    @Override
    public List<ProductoDTO> getDetalleProductosDTOByIdCabeceraEgreso(Integer idCabeceraEgreso, Integer estado) {

        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append("SELECT p.id id_producto, p.id_padre, UPPER(p.codigo_fabricante), p.codigo_anterior, p.codigo_interno, c.id id_categoria, c.nombre categoria, ma.id id_marca, ma.marca, ");
        sbQuery.append("mo.id id_modelo, mo.modelo, UPPER(p.descripcion_compra), UPPER(p.descripcion_venta), p.equipo, p.campo_1, p.campo_2, p.fecha_registro, p.id_usuario_registro, ");
        sbQuery.append("p.fecha_modificacion, p.id_usuario_modicacion, p.estado, 1 count, t.nombre, p.requiere_serial, dip.serial, b.id id_bodega, UPPER(b.codigo), UPPER(b.nombre), dip.estado_proceso, ");
        sbQuery.append("ma.codigo codigo_marca, c.codigo codigo_categoria, p.tiene_compatible, um.nombre unidad_medida,  p.stock_minimo, p.stock_maximo, ");
        sbQuery.append("  (SELECT GROUP_CONCAT(modelo.modelo) from modelo ");
        sbQuery.append("   INNER JOIN producto_modelo ON modelo.id = producto_modelo.id_modelo ");
        sbQuery.append("   WHERE p.id = id_producto) compatibles, p.codigo_barras ");
        sbQuery.append("FROM cabecera_egreso cab ");
        sbQuery.append("INNER JOIN detalle_egreso d ON cab.id = d.id_cabecera_egreso ");
        sbQuery.append("INNER JOIN detalle_egreso_inventario dei ON d.id = dei.id_detalle_egreso ");
        sbQuery.append("INNER JOIN detalle_inventario_producto dip ON dip.id = dei.id_detalle_inventario_producto ");
        sbQuery.append("INNER JOIN bodega b ON  b.id = dip.id_bodega ");
        sbQuery.append("INNER JOIN producto p ON p.id = d.id_producto ");
        sbQuery.append("INNER JOIN unidad_medida um ON um.id = p.id_unidad_medida ");
        sbQuery.append("INNER JOIN tipo_producto t ON t.id = p.id_tipo_producto ");
        sbQuery.append("LEFT  JOIN categoria c ON p.id_categoria = c.id ");
        sbQuery.append("LEFT  JOIN modelo mo ON  mo.id = p.id_modelo ");
        sbQuery.append("LEFT  JOIN marca ma ON  ma.id = p.id_marca ");
        sbQuery.append("WHERE cab.id=:idCabeceraEgreso AND cab.estado =:estado AND d.estado = 1 AND p.requiere_serial = 1 AND dip.estado =1 ");
        sbQuery.append("UNION ");
        sbQuery.append("SELECT p.id id_producto, p.id_padre, UPPER(p.codigo_fabricante), p.codigo_anterior, p.codigo_interno, c.id id_categoria, c.nombre categoria, ma.id id_marca, ma.marca, ");
        sbQuery.append("mo.id id_modelo, mo.modelo, p.descripcion_compra, UPPER(p.descripcion_venta) , p.equipo, p.campo_1, p.campo_2, p.fecha_registro, p.id_usuario_registro, ");
        sbQuery.append("p.fecha_modificacion, p.id_usuario_modicacion, p.estado, COUNT(p.id) count, t.nombre, p.requiere_serial, UPPER(dip.serial), b.id, UPPER(b.codigo), UPPER(b.nombre), dei.estado_proceso, ");
        sbQuery.append("ma.codigo codigo_marca, c.codigo codigo_categoria, p.tiene_compatible, um.nombre unidad_medida, p.stock_minimo, p.stock_maximo, ");
        sbQuery.append("  (SELECT GROUP_CONCAT(modelo.modelo) from modelo ");
        sbQuery.append("   INNER JOIN producto_modelo ON modelo.id = producto_modelo.id_modelo ");
        sbQuery.append("   WHERE p.id = id_producto) compatibles, p.codigo_barras ");
        sbQuery.append("FROM cabecera_egreso cab ");
        sbQuery.append("INNER JOIN detalle_egreso d ON cab.id = d.id_cabecera_egreso ");
        sbQuery.append("INNER JOIN detalle_egreso_inventario dei ON d.id = dei.id_detalle_egreso ");
        sbQuery.append("INNER JOIN detalle_inventario_producto dip ON dip.id = dei.id_detalle_inventario_producto ");
        sbQuery.append("INNER JOIN bodega b ON  b.id = dip.id_bodega ");
        sbQuery.append("INNER JOIN producto p ON p.id = d.id_producto ");
        sbQuery.append("INNER JOIN unidad_medida um ON um.id = p.id_unidad_medida ");
        sbQuery.append("INNER JOIN tipo_producto t ON t.id = p.id_tipo_producto ");
        sbQuery.append("LEFT  JOIN categoria c ON p.id_categoria = c.id ");
        sbQuery.append("LEFT  JOIN modelo mo ON  mo.id = p.id_modelo ");
        sbQuery.append("LEFT  JOIN marca ma ON  ma.id = p.id_marca ");
        sbQuery.append("WHERE cab.id=:idCabeceraEgreso AND cab.estado =:estado AND d.estado = 1 AND p.requiere_serial = 0 AND dei.estado =1 ");
        sbQuery.append("GROUP BY  p.id ");

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());
        query.setParameter("idCabeceraEgreso", idCabeceraEgreso);
        query.setParameter("estado", estado);

//        System.out.println("SQL(): " + sbQuery.toString());
        List<Object[]> resultObject = (List<Object[]>) query.list();

        return cargarResultToList(resultObject);
    }

    @Override
    public List<ProductoDTO> getSolicitudProductosDTOByIdCabeceraEgreso(Integer idCabeceraEgreso, Integer estado) {

        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append("SELECT p.id id_producto, p.id_padre, UPPER(p.codigo_fabricante), p.codigo_anterior, p.codigo_interno, c.id id_categoria, c.nombre categoria, ma.id id_marca, ma.marca, ");
        sbQuery.append("mo.id id_modelo, mo.modelo, p.descripcion_compra, UPPER(p.descripcion_venta) , p.equipo, p.campo_1, p.campo_2, p.fecha_registro, p.id_usuario_registro, ");
        sbQuery.append("p.fecha_modificacion, p.id_usuario_modicacion, p.estado, d.cantidad count, t.nombre, p.requiere_serial, '' serial , b.id, UPPER(b.codigo), UPPER(b.nombre), '' estado_proceso, ");
        sbQuery.append("ma.codigo codigo_marca, c.codigo codigo_categoria, p.tiene_compatible, um.nombre unidad_medida, p.stock_minimo, p.stock_maximo, ");
        sbQuery.append("  (SELECT GROUP_CONCAT(modelo.modelo) from modelo ");
        sbQuery.append("   INNER JOIN producto_modelo ON modelo.id = producto_modelo.id_modelo ");
        sbQuery.append("   WHERE p.id = id_producto) compatibles, p.codigo_barras ");
        sbQuery.append("FROM cabecera_egreso cab ");
        sbQuery.append("INNER JOIN detalle_egreso d ON cab.id = d.id_cabecera_egreso ");
        sbQuery.append("INNER JOIN bodega b ON  b.id = cab.id_bodega ");
        sbQuery.append("INNER JOIN producto p ON p.id = d.id_producto ");
        sbQuery.append("INNER JOIN unidad_medida um ON um.id = p.id_unidad_medida ");
        sbQuery.append("INNER JOIN tipo_producto t ON t.id = p.id_tipo_producto ");
        sbQuery.append("LEFT  JOIN categoria c ON p.id_categoria = c.id ");
        sbQuery.append("LEFT  JOIN modelo mo ON  mo.id = p.id_modelo ");
        sbQuery.append("LEFT  JOIN marca ma ON  ma.id = p.id_marca ");
        sbQuery.append("WHERE cab.id=:idCabeceraEgreso AND cab.estado =:estado AND d.estado = 1 ");
        sbQuery.append("GROUP BY  p.id ");

        Query query = sessionFactory.getCurrentSession().createSQLQuery(sbQuery.toString());
        query.setParameter("idCabeceraEgreso", idCabeceraEgreso);
        query.setParameter("estado", estado);
//        query.setParameter("estadoReservado", Enums.ESTADO_PROCESO_RESERVADO.getValue());
//        query.setParameter("estadoDespachado", Enums.ESTADO_PROCESO_DESPACHADO.getValue());

//        System.out.println("SQL(): " + sbQuery.toString());
        List<Object[]> resultObject = (List<Object[]>) query.list();

        return cargarResultToList(resultObject);
    }

    @Override
    public List<Producto> getProductosHijosByIdPadre(Integer idPadre) {

        System.out.println("getProductosHijosByIdPadre()");

        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append("SELECT DISTINCT p ");
        sbQuery.append("FROM Producto p, Producto h ");
        sbQuery.append("WHERE (p.id = h.idPadre )  AND (p.idPadre =:idPadre or h.id =:idPadre) ");
        sbQuery.append(" AND p.estado = :estado ");
        sbQuery.append("ORDER BY p.id, p.idAncestro, p.codigoFabricante, p.codigoAnterior");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idPadre", idPadre);
        query.setParameter("estado", EstadosEnum.ACTIVO.getValue());

        return query.list();
    }

    @Override
    public List<Producto> getProductosHijosByIdAncestro(Integer idAncestro) {
        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append("SELECT DISTINCT p ");
        sbQuery.append("FROM Producto p  ");
        sbQuery.append("WHERE (p.id = :idAncestro OR p.idAncestro = :idAncestro) ");
        sbQuery.append(" AND p.estado = :estado ");
        sbQuery.append("ORDER BY p.id, p.idAncestro, p.codigoFabricante, p.codigoAnterior");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idAncestro", idAncestro);
        query.setParameter("estado", EstadosEnum.ACTIVO.getValue());

        return query.list();
    }

    @Override
    public List<Producto> getOnlyProductos() {
        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append("FROM Producto p ");
        sbQuery.append("WHERE p.idPadre is null AND p.idTipoProducto.codigo =:tipoProducto ");
        sbQuery.append("AND p.idModelo.id IS NOT NULL AND p.estado = :estado ");

        sbQuery.append("ORDER BY p.id, p.idAncestro, p.codigoFabricante, p.codigoAnterior");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        query.setParameter("estado", EstadosEnum.ACTIVO.getValue());
        query.setParameter("tipoProducto", Enums.TIPO_PRODUCTO_EQUIPO.getValue());

        return query.list();
    }

    @Override
    @Transactional
    public List<Producto> getOnlyProductosByCodigoCategoria(String codigoCategoria) {
        StringBuilder sbQuery = new StringBuilder();

        sbQuery.append("FROM Producto p ");
        sbQuery.append("WHERE p.idPadre is null AND p.idTipoProducto.codigo = :tipoProducto ");
        sbQuery.append("AND p.idModelo.id IS NOT NULL AND p.estado = :estado  ");

        if (CategoriasEnum.CAT_IMPRESORAS.getValue().equalsIgnoreCase(codigoCategoria)
                || CategoriasEnum.CAT_MULTIFUNCION_BLANCO_NEGRO.getValue().equalsIgnoreCase(codigoCategoria)
                || CategoriasEnum.CAT_MULTIFUNCION_COLOR.getValue().equalsIgnoreCase(codigoCategoria)) {
            sbQuery.append("AND ( p.idCategoria.codigo =:codigoImpresoras ");
            sbQuery.append("OR p.idCategoria.codigo =:codigoMultifuncionBN ");
            sbQuery.append("OR p.idCategoria.codigo =:codigoMultifuncionColor) ");
        } else {
            sbQuery.append("AND  p.idCategoria.codigo =:codigoCategoria ");
        }
        sbQuery.append("ORDER BY p.id, p.idAncestro, p.codigoFabricante, p.codigoAnterior ");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());

        query.setParameter("estado", EstadosEnum.ACTIVO.getValue());
        query.setParameter("tipoProducto", Enums.TIPO_PRODUCTO_EQUIPO.getValue());

        if (CategoriasEnum.CAT_IMPRESORAS.getValue().equalsIgnoreCase(codigoCategoria)
                || CategoriasEnum.CAT_MULTIFUNCION_BLANCO_NEGRO.getValue().equalsIgnoreCase(codigoCategoria)
                || CategoriasEnum.CAT_MULTIFUNCION_COLOR.getValue().equalsIgnoreCase(codigoCategoria)) {
            query.setParameter("codigoImpresoras", CategoriasEnum.CAT_IMPRESORAS.getValue());
            query.setParameter("codigoMultifuncionBN", CategoriasEnum.CAT_MULTIFUNCION_BLANCO_NEGRO.getValue());
            query.setParameter("codigoMultifuncionColor", CategoriasEnum.CAT_MULTIFUNCION_COLOR.getValue());
        } else {
            query.setParameter("codigoCategoria", codigoCategoria);
        }

        return query.list();
    }

    @Override
    public Producto getProductoById(Integer id) {
        Object result = sessionFactory.getCurrentSession().createQuery("from Producto WHERE id=" + id + "").uniqueResult();
        Producto producto = result != null ? (Producto) result : null;

        return producto;
    }

    @Override
    public List<Producto> getProductosByEstado(Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT p from Producto p ");
        sbQuery.append("WHERE p.estado=:estado ");
        sbQuery.append("ORDER BY p.codigoAncestro, p.id");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("estado", estado);
        return query.list();
    }

    @Override
    public Producto getProductoBySerial(String serial) {
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT p "
                + "FROM DetalleInventarioProducto as det_inv_p right JOIN det_inv_p.idDetalleInventario as det "
                + "RIGHT JOIN det.idProducto as p "
                + "WHERE p.estado = 1 and det_inv_p.serial = :serial");
        query.setParameter("serial", serial);

        List<Producto> list = query.list();
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<Producto> getProductos() {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT p from Producto p ");
        sbQuery.append("ORDER BY p.estado DESC, p.codigoAncestro, p.id ");

        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        return query.list();
    }

    @Override
    public List<Producto> getProductosCompatiblesByIdPadre(Integer idPadre, Integer estado) {
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT DISTINCT p from Producto p ,");
        sbQuery.append("ProductoModelo pm ");
        sbQuery.append("WHERE (p.idAncestro = pm.idProducto.id OR p.id = pm.idProducto.id) ");
        sbQuery.append("AND (p.id =:idPadre OR p.idAncestro = :idPadre) AND p.estado=:estado ");
        Query query = sessionFactory.getCurrentSession().createQuery(sbQuery.toString());
        query.setParameter("idPadre", idPadre);
        query.setParameter("estado", estado);
        return query.list();

    }

    @Override
    public Producto getProductoByCodigoFabricante(String codigo) {
        Object result = sessionFactory.getCurrentSession().createQuery("from Producto p WHERE p.codigoFabricante ='" + codigo + "'").uniqueResult();
        Producto producto = result != null ? (Producto) result : null;

        return producto;
    }

}
