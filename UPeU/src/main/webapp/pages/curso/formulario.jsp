<%@include file="/common/taglibs.jsp"%>

<c:choose>
	<c:when test="${not empty curso.id}">
		<c:url value="cursos/editar" var="urlSubmit">
		</c:url>
	</c:when>
	<c:otherwise>
		<c:url value="cursos/nuevo" var="urlSubmit">
		</c:url>
	</c:otherwise>
</c:choose>

<form action="${urlSubmit}" method="POST" id="formulario">
	<h1>Registro de Curso</h1>
	<p>
		<input type="text" value="${curso.nombre}" name="nombre"
			placeholder="Curso" autofocus="autofocus" required>
	</p>
	<p>
		<input type="text" value="${curso.nroHoras}" name="nroHoras"
			placeholder="# Horas" required>
	</p>
	<p>
		<input type="text" value="${curso.nroCreditos}" name="nroCreditos"
			placeholder="# Creditos" required>
	</p>
	<p>
		<input type="submit" value="Guardar">&nbsp;&nbsp;&nbsp;<input
			type="button" value="Cancelar" onclick="upeu.cargarUrl('cursos');">
		<c:if test="${not empty curso.id}">
			<input type="hidden" name="id" value="${curso.id}">
		</c:if>
	</p>
</form>
<script>
	upeu.enviarFormulario({
		id : 'formulario',
		target : 'contenido'
	});
</script>