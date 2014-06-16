<%@include file="/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${not empty docente.id}">
		<c:url value="docentes/editar" var="urlSubmit">
		</c:url>
	</c:when>
	<c:otherwise>
		<c:url value="docentes/nuevo" var="urlSubmit">
		</c:url>
	</c:otherwise>
</c:choose>
<form action="${urlSubmit}" method="POST" id="formulario">
	<h1>Registro de Docente</h1>
	<p>
		<input type="text" value="${docente.nombre}" name="nombre"
			placeholder="Nombre" autofocus="autofocus" required>
	</p>
	<p>
		<input type="text" value="${docente.apePat}" name="paterno"
			placeholder="Paterno" required>
	</p>
	<p>
		<input type="text" value="${docente.apeMat}" name="materno"
			placeholder="Materno" required>
	</p>
	<p>
		<input type="submit" value="Guardar">&nbsp;&nbsp;&nbsp;<input
			type="button" value="Cancelar" onclick="upeu.cargarUrl('docentes');">
		<c:if test="${not empty docente.id}">
			<input type="hidden" name="id" value="${docente.id}">
		</c:if>
	</p>
</form>
<script>
	upeu.enviarFormulario({
		id : 'formulario',
		target : 'contenido'
	});
</script>