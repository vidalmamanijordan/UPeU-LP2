<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Home</title>
<link href="resources/css/normalize.css" rel="stylesheet">
<link href="resources/css/estiloLogin.css" rel="stylesheet">
</head>
<body>
	<div id="contenedorLogin">
		<form action="login" method="post">
			<h1>Ingreso al sistema</h1>
			<p>
				<input type="text" name="username" id="username" required autofocus
					placeholder="Usuario">
			</p>
			<p>
				<input type="password" name="password" id="password" required
					placeholder="Contraseña">
			</p>
			<p>
				<input type="submit" value="Ingresar">
			</p>
		</form>
	</div>
</body>
</html>