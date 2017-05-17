package com.javaen.dao;
import java.util.Date;
import java.util.List;

import com.javaen.model.Activo;
import com.javaen.model.Filtro;
import com.javaen.model.TipoActivo;


public interface ActivosDao {
	
	public void addActivo(Activo a);
	public void updateActivo(Activo a);
	public List<Activo> listActivos();
	public Activo getActivoById(int id);
	public void removeActivo(int id);
	public List<TipoActivo> listTipoActivos();
	public Activo getActivoByName(String name);
	public TipoActivo getTipoById(String id);
	public List<Activo> filtrar(Filtro filtro);
	public Date convertirStringToDate(String fecha);
	
}
