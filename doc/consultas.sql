-- NOMBRE Y CONTRASEÑA DE USUARIOS PARA METODO AUTENTICAR
select nombre, contraseña
from k1furydb.usuario
where nombre = ? and contraseña = ?;

