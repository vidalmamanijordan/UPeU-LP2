<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty lp}">
		<table class="tabla-cebra">
			<caption>Lista de Alumnos</caption>
			<tr>
				<td colspan="5"><a href="#"
					onclick="upeu.cargarUrl('alumnos/nuevo')">+ Nuevo</a></td>
			</tr>
			<tr>
				<th>#</th>
				<th>Paterno</th>
				<th>Materno</th>
				<th>Nombre</th>
				<th>Opc</th>
			</tr>
			<c:forEach items="${lp}" var="p" varStatus="ps">
				<tr>
					<td>${ps.count}</td>
					<td>${p.apePat}</td>
					<td>${p.apeMat}</td>
					<td>${p.nombre}</td>
					<td><a href="#"
						onclick="upeu.cargarUrl('alumnos/editar?id=${p.id}')">[Edit]</a>
						<a href="#"
						onclick="upeu.cargarUrl('alumnos/eliminar?id=${p.id}')">[Delete]</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<p>
			<a href="#" onclick="upeu.cargarUrl('alumnos/nuevo')">+ Nuevo</a>
		</p>
		<div class="aviso">No se encontraron alumnos</div>
	</c:otherwise>
</c:choose>