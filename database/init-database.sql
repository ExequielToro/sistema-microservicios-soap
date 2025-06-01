--------------------------------------------------------
-- Archivo creado  - jueves-agosto-08-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence PRODUCTO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PRODUCTO_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 5 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table PRODUCTO
--------------------------------------------------------

  CREATE TABLE "PRODUCTO" 
   (	"ID_PRODUCTO" NUMBER, 
	"NOMBRE" VARCHAR2(300 BYTE), 
	"PRECIO" NUMBER, 
	"STOCK" NUMBER, 
	"BTU" NUMBER, 
	"MARCA" VARCHAR2(300 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into PRODUCTO
SET DEFINE OFF;
Insert into PRODUCTO (ID_PRODUCTO,NOMBRE,PRECIO,STOCK,BTU,MARCA) values ('1','AIRE','1000','10','1000','NIKE');
Insert into PRODUCTO (ID_PRODUCTO,NOMBRE,PRECIO,STOCK,BTU,MARCA) values ('2','AIRE','199','70','9000','DIADORA');
Insert into PRODUCTO (ID_PRODUCTO,NOMBRE,PRECIO,STOCK,BTU,MARCA) values ('3','Aire Pared Ultra','8000000','80','9500','JORDAN');
Insert into PRODUCTO (ID_PRODUCTO,NOMBRE,PRECIO,STOCK,BTU,MARCA) values ('4','JHAKKAKA','2000','499','2999','KKK');
--------------------------------------------------------
--  DDL for Index PRODUCTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRODUCTO_PK" ON "PRODUCTO" ("ID_PRODUCTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PRODUCTO_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRODUCTO_PK" ON "PRODUCTO" ("ID_PRODUCTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Package PRODUCTO_PKG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE "PRODUCTO_PKG" 
is

type PRODUCTO_tapi_rec is record (
PRECIO  PRODUCTO.PRECIO%type
,BTU  PRODUCTO.BTU%type
,MARCA  PRODUCTO.MARCA%type
,ID_PRODUCTO  PRODUCTO.ID_PRODUCTO%type
,NOMBRE  PRODUCTO.NOMBRE%type
,STOCK  PRODUCTO.STOCK%type
);
type PRODUCTO_tapi_tab is table of PRODUCTO_tapi_rec;


procedure proc_mostrarTodosProducto (p_cursor out SYS_REFCURSOR);
procedure proc_mostrarUnProducto (p_id_producto producto.id_producto%TYPE,
p_cursor out SYS_REFCURSOR);

procedure upd_descuentaStock(p_id_producto producto.id_producto%TYPE,
p_cantidad number);
-- insert
procedure ins (
p_PRECIO in PRODUCTO.PRECIO%type default null 
,p_BTU in PRODUCTO.BTU%type default null 
,p_MARCA in PRODUCTO.MARCA%type default null 

,p_NOMBRE in PRODUCTO.NOMBRE%type default null 
,p_STOCK in PRODUCTO.STOCK%type default null 
);
-- update
procedure upd (
p_PRECIO in PRODUCTO.PRECIO%type default null 
,p_BTU in PRODUCTO.BTU%type default null 
,p_MARCA in PRODUCTO.MARCA%type default null 
,p_ID_PRODUCTO in PRODUCTO.ID_PRODUCTO%type
,p_NOMBRE in PRODUCTO.NOMBRE%type default null 
,p_STOCK in PRODUCTO.STOCK%type default null 
);
-- delete
procedure del (
p_ID_PRODUCTO in PRODUCTO.ID_PRODUCTO%type
);
end PRODUCTO_pkg;

/
--------------------------------------------------------
--  DDL for Package Body PRODUCTO_PKG
--------------------------------------------------------

  CREATE OR REPLACE NONEDITIONABLE PACKAGE BODY "PRODUCTO_PKG" 
is

procedure proc_mostrarTodosProducto (p_cursor out SYS_REFCURSOR)
IS 
BEGIN 
    OPEN p_cursor FOR
    SELECT * FROM PRODUCTO 
    order by id_producto;



END;

procedure proc_mostrarUnProducto (p_id_producto producto.id_producto%TYPE,
p_cursor out SYS_REFCURSOR)
IS 
BEGIN 
    OPEN p_cursor FOR
    SELECT * FROM PRODUCTO WHERE id_producto=p_id_producto;



END;

procedure upd_descuentaStock(p_id_producto producto.id_producto%TYPE,
p_cantidad number)
is
begin 
    update PRODUCTO 
    SET stock = stock - p_cantidad 
    where id_producto=p_id_producto;


end;

-- insert
procedure ins (
p_PRECIO in PRODUCTO.PRECIO%type default null,
p_BTU in PRODUCTO.BTU%type default null,
p_MARCA in PRODUCTO.MARCA%type default null,
p_NOMBRE in PRODUCTO.NOMBRE%type default null,
p_STOCK in PRODUCTO.STOCK%type default null
) is
begin
    insert into PRODUCTO(
        ID_PRODUCTO, -- Agregar el ID aquí
        PRECIO,
        BTU,
        MARCA,
        NOMBRE,
        STOCK
    ) values (
        producto_seq.NEXTVAL, -- Usar la secuencia para generar el ID
        p_PRECIO,
        p_BTU,
        p_MARCA,
        p_NOMBRE,
        p_STOCK
    );
end;

-- update
procedure upd (
p_PRECIO in PRODUCTO.PRECIO%type default null 
,p_BTU in PRODUCTO.BTU%type default null 
,p_MARCA in PRODUCTO.MARCA%type default null 
,p_ID_PRODUCTO in PRODUCTO.ID_PRODUCTO%type
,p_NOMBRE in PRODUCTO.NOMBRE%type default null 
,p_STOCK in PRODUCTO.STOCK%type default null 
) is
BEGIN
    UPDATE PRODUCTO 
    SET
        PRECIO = COALESCE(p_PRECIO, PRECIO),
        BTU = COALESCE(p_BTU, BTU),
        MARCA = COALESCE(p_MARCA, MARCA),
        NOMBRE = COALESCE(p_NOMBRE, NOMBRE),
        STOCK = COALESCE(p_STOCK, STOCK)
    WHERE ID_PRODUCTO = p_ID_PRODUCTO;
END;
-- del
procedure del (
p_ID_PRODUCTO in PRODUCTO.ID_PRODUCTO%type
) is
begin
delete from PRODUCTO
where ID_PRODUCTO = p_ID_PRODUCTO;
end;
end PRODUCTO_pkg;

/
--------------------------------------------------------
--  Constraints for Table PRODUCTO
--------------------------------------------------------

  ALTER TABLE "PRODUCTO" MODIFY ("ID_PRODUCTO" NOT NULL ENABLE);
  ALTER TABLE "PRODUCTO" ADD CONSTRAINT "PRODUCTO_PK" PRIMARY KEY ("ID_PRODUCTO")
  USING INDEX "PRODUCTO_PK"  ENABLE;
