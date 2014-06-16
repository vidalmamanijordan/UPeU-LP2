<%@include file="/common/taglibs.jsp"%>

<c:choose>
	<c:when test="${not empty alumno.id}">
		<c:url value="alumnos/editar" var="urlSubmit">
		</c:url>
	</c:when>
	<c:otherwise>
		<c:url value="alumnos/nuevo" var="urlSubmit">
		</c:url>
	</c:otherwise>
</c:choose>

<form action="${urlSubmit}" method="POST" id="formulario">
	<h1>Registro de Alumno</h1>
	<p>
		<input type="text" value="${alumno.nombre}" name="nombre"
			placeholder="Nombre" autofocus="autofocus" required>
	</p>
	<p>
		<input type="text" value="${alumno.apePat}" name="paterno"
			placeholder="Paterno" required>
	</p>
	<p>
		<input type="text" value="${alumno.apeMat}" name="materno"
			placeholder="Materno" required>
	</p>
	<p>
		<input type="submit" value="Guardar">&nbsp;&nbsp;&nbsp;<input
			type="button" value="Cancelar" onclick="upeu.cargarUrl('alumnos');">
		<c:if test="${not empty alumno.id}">
			<input type="hidden" name="id" value="${alumno.id}">
		</c:if>
	</p>
</form>

<script>
	upeu.enviarFormulario({
		id : 'formulario',
		target : 'contenido'
	});
</script>