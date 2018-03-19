set TYPES=calc user

set "BASEDIR=D:\Development\Workspaces\iJEE\SOAPTest\Server"
mkdir %BASEDIR%\wsdl\src
mkdir %BASEDIR%\wsdl\target

setlocal EnableDelayedExpansion

(for %%a in (%TYPES%) do (
    set "WSDL_URL=http://127.0.0.1:8555/%%a?wsdl"
    set "PACKAGE=xyz.meistertobias.soap.client.gen.%%a"

    wsimport -keep -p !PACKAGE! -s %BASEDIR%\wsdl\src -d %BASEDIR%\wsdl\target !WSDL_URL!
))
