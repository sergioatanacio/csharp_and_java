# 1. Crear la solución con el nombre del proyecto
dotnet new sln -n v2_LibreriaMilenaDiego

# 2. Crear los proyectos para cada capa
dotnet new classlib -n CapaDatos
dotnet new classlib -n CapaNegocio
dotnet new classlib -n CapaEntidad
dotnet new winforms -n CapaPresentacion

# 3. Agregar cada proyecto a la solución
dotnet sln v2_LibreriaMilenaDiego.sln add CapaDatos/CapaDatos.csproj
dotnet sln v2_LibreriaMilenaDiego.sln add CapaNegocio/CapaNegocio.csproj
dotnet sln v2_LibreriaMilenaDiego.sln add CapaEntidad/CapaEntidad.csproj
dotnet sln v2_LibreriaMilenaDiego.sln add CapaPresentacion/CapaPresentacion.csproj

# 4. Configurar las referencias entre proyectos
dotnet add CapaNegocio/CapaNegocio.csproj reference CapaDatos/CapaDatos.csproj
dotnet add CapaNegocio/CapaNegocio.csproj reference CapaEntidad/CapaEntidad.csproj
dotnet add CapaPresentacion/CapaPresentacion.csproj reference CapaNegocio/CapaNegocio.csproj
dotnet add CapaPresentacion/CapaPresentacion.csproj reference CapaEntidad/CapaEntidad.csproj

# 5. (Opcional) Restaurar paquetes para verificar que todo está correctamente configurado
dotnet restore

dotnet build .\v2_LibreriaMilenaDiego.sln
dotnet run 


