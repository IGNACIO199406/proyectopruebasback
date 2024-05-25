package com.proyectos.app.service;

import com.proyectos.app.entity.Proveedor;
import com.proyectos.app.model.ResponseGeneric;

public interface ProveedorService {
    public ResponseGeneric getAllProveedors();
    public ResponseGeneric getAllExtras();
    public ResponseGeneric getProveedorById(Long empleadoId);
    public ResponseGeneric createProveedor(Proveedor empleados);
    public ResponseGeneric updateProveedor(Integer empleadoId, Proveedor empleados);
    public ResponseGeneric deleteProveedor(Long empleadoId);
}
