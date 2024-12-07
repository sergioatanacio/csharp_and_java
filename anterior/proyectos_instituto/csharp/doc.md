mkdir LibreriaMilenaDiego
cd LibreriaMilenaDiego
dotnet new sln -n LibreriaMilenaDiego



dotnet new winforms -n CapaPresentacion
dotnet new classlib -n CapaNegocio
dotnet new classlib -n CapaDatos
dotnet new classlib -n CapaEntidad


dotnet sln add CapaPresentacion/CapaPresentacion.csproj
dotnet sln add CapaNegocio/CapaNegocio.csproj
dotnet sln add CapaDatos/CapaDatos.csproj
dotnet sln add CapaEntidad/CapaEntidad.csproj


dotnet add CapaPresentacion/CapaPresentacion.csproj reference CapaNegocio/CapaNegocio.csproj
dotnet add CapaNegocio/CapaNegocio.csproj reference CapaDatos/CapaDatos.csproj
dotnet add CapaNegocio/CapaNegocio.csproj reference CapaEntidad/CapaEntidad.csproj
dotnet add CapaDatos/CapaDatos.csproj reference CapaEntidad/CapaEntidad.csproj



dotnet add CapaDatos/CapaDatos.csproj package MySql.Data


dotnet add CapaDatos/CapaDatos.csproj package Microsoft.EntityFrameworkCore
dotnet add CapaDatos/CapaDatos.csproj package Microsoft.EntityFrameworkCore.MySql


