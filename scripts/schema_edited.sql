-- Base
CREATE TABLE Base 
    ( 
		id          NUMBER  NOT NULL , 
		name        VARCHAR2 (30) , 
		location_id NUMBER  NOT NULL , 
		type        VARCHAR2 (8)  NOT NULL 
    ) 
;

ALTER TABLE Base ADD CONSTRAINT Base_PK PRIMARY KEY ( id );

CREATE VIEW Barracks AS
SELECT * FROM Base WHERE TYPE = 1;
CREATE VIEW Storage AS
SELECT * FROM Base WHERE TYPE = 2;


-- Equipment
CREATE TABLE Equipment 
    ( 
		id                NUMBER  NOT NULL , 
		status            NUMBER , 
		equipment_type_id NUMBER  NOT NULL , 
		soldier_id        NUMBER , 
		storage_id        NUMBER 
    )
;
ALTER TABLE Equipment ADD CONSTRAINT Equipment_PK PRIMARY KEY ( id );

-- Equipment_Type
CREATE TABLE Equipment_Type 
    ( 
		id    NUMBER  NOT NULL , 
		type  VARCHAR2 (256) 
    ) 
;

ALTER TABLE Equipment_Type ADD CONSTRAINT Equipment_Type_PK PRIMARY KEY ( id );

-- Location
CREATE TABLE Location 
    ( 
		id      NUMBER  NOT NULL , 
		country VARCHAR2 (256) , 
		city    VARCHAR2 (256) 
    ) 
;

ALTER TABLE Location  ADD CONSTRAINT Location_PK PRIMARY KEY ( id );

-- Medal
CREATE TABLE Medal 
    ( 
		id               NUMBER   NOT NULL , 
		medal_type_id    NUMBER   NOT NULL , 
		award_date       DATE , 
		participation_id NUMBER NOT NULL,
		description      VARCHAR2 (256) 
    ) 
;
CREATE UNIQUE INDEX Medal_IDX ON Medal ( id ASC );
ALTER TABLE Medal ADD CONSTRAINT Medal_PK PRIMARY KEY ( medal_type_id, id );

CREATE TABLE Medal_Type 
    ( 
		id    NUMBER  NOT NULL , 
		name  VARCHAR2 (30) 
    ) 
;

ALTER TABLE Medal_Type ADD CONSTRAINT Medal_Type_PK PRIMARY KEY ( id );

-- Mission
CREATE TABLE Mission 
    ( 
		id            NUMBER  NOT NULL , 
		name          VARCHAR2 (30) , 
		description   VARCHAR2 (256) , 
		start_date    DATE , 
		end_date      DATE , 
		status        NUMBER , 
		location_id   NUMBER  NOT NULL 
    ) 
;
CREATE UNIQUE INDEX Mission_IDX ON Mission ( location_id ASC );
ALTER TABLE Mission ADD CONSTRAINT Mission_PK PRIMARY KEY ( id );

-- Participation
CREATE TABLE Participation 
    ( 
		id          NUMBER  NOT NULL , 
		soldier_id  NUMBER  NOT NULL , 
		mission_id  NUMBER  NOT NULL 
    ) 
;

ALTER TABLE Participation ADD CONSTRAINT Participation_PK PRIMARY KEY ( id ) ;

-- Rank
CREATE TABLE Rank 
    ( 
		id          NUMBER  NOT NULL , 
		name        VARCHAR2 (30) , 
		description VARCHAR2 (256) 
    ) 
;
ALTER TABLE Rank  ADD CONSTRAINT Rank_PK PRIMARY KEY ( id ) ;

-- Soldier
CREATE TABLE Soldier 
    ( 
		id              NUMBER  NOT NULL , 
		first_name      VARCHAR2 (256) , 
		last_name       VARCHAR2 (256) , 
		date_of_joining DATE , 
		rank_id         NUMBER  NOT NULL , 
		chief_id        NUMBER , 
		vehicle_id      NUMBER , 
		barracks_id     NUMBER 
    ) 
;
CREATE UNIQUE INDEX Soldier_IDX ON Soldier ( vehicle_id ASC );
ALTER TABLE Soldier ADD CONSTRAINT Soldier_PK PRIMARY KEY ( id );

CREATE TABLE Specializing 
    ( 
		specialty_id NUMBER  NOT NULL , 
		soldier_id   NUMBER  NOT NULL 
    ) 
;

ALTER TABLE Specializing ADD CONSTRAINT Specializing_PK PRIMARY KEY ( specialty_id, soldier_id ) ;

CREATE TABLE Specialty 
    ( 
		id        NUMBER  NOT NULL , 
		name        VARCHAR2 (30) , 
		description VARCHAR2 (256) 
    ) 
;

ALTER TABLE Specialty  ADD CONSTRAINT Specialty_PK PRIMARY KEY ( id ) ;


CREATE TABLE Vehicle 
    ( 
		id              NUMBER  NOT NULL , 
		vehicle_type_id NUMBER  NOT NULL , 
		storage_id      NUMBER , 
		soldier_id      NUMBER 
    ) 
;
CREATE UNIQUE INDEX Vehicle_IDX ON Vehicle ( soldier_id ASC ) ;
ALTER TABLE Vehicle ADD CONSTRAINT Vehicle_PK PRIMARY KEY ( id ) ;

CREATE TABLE Vehicle_Type 
    ( 
		id         NUMBER  NOT NULL , 
		model_name VARCHAR2 (256) , 
		name       VARCHAR2 (30) 
    ) 
;
ALTER TABLE Vehicle_Type  ADD CONSTRAINT Vehicle_Type_PK PRIMARY KEY ( id );


-- FK
ALTER TABLE Base ADD CONSTRAINT Base_Location_FK FOREIGN KEY ( location_id ) REFERENCES Location ( id );
ALTER TABLE Equipment ADD CONSTRAINT Equipment_Equipment_Type_FK FOREIGN KEY ( equipment_type_id ) REFERENCES Equipment_Type ( id );
ALTER TABLE Equipment ADD CONSTRAINT Equipment_Soldier_FK FOREIGN KEY ( soldier_id ) REFERENCES Soldier ( id );
ALTER TABLE Equipment ADD CONSTRAINT Equipment_Storage_FK FOREIGN KEY ( storage_id ) REFERENCES Base ( id );
ALTER TABLE Medal ADD CONSTRAINT Medal_Medal_Type_FK FOREIGN KEY ( medal_type_id ) REFERENCES Medal_Type ( id );
ALTER TABLE Medal ADD CONSTRAINT Medal_Participation_FK FOREIGN KEY ( participation_id ) REFERENCES Participation ( id );
ALTER TABLE Mission ADD CONSTRAINT Mission_Location_FK FOREIGN KEY ( location_id ) REFERENCES Location ( id );
ALTER TABLE Participation ADD CONSTRAINT Participation_Mission_FK FOREIGN KEY ( mission_id ) REFERENCES Mission ( id );
ALTER TABLE Participation ADD CONSTRAINT Participation_Soldier_FK FOREIGN KEY ( soldier_id ) REFERENCES Soldier ( id );
ALTER TABLE Soldier ADD CONSTRAINT Soldier_Rank_FK FOREIGN KEY ( rank_id ) REFERENCES Rank ( id );
ALTER TABLE Soldier ADD CONSTRAINT Soldier_Soldier_FK FOREIGN KEY ( chief_id ) REFERENCES Soldier ( id );
ALTER TABLE Soldier ADD CONSTRAINT Soldier_Vehicle_FK FOREIGN KEY ( vehicle_id ) REFERENCES Vehicle ( id );
ALTER TABLE Soldier ADD CONSTRAINT Soldier_Barracks_FK FOREIGN KEY ( barracks_id ) REFERENCES Base ( id );
ALTER TABLE Specializing ADD CONSTRAINT Specializing_Soldier_FK FOREIGN KEY ( soldier_id ) REFERENCES Soldier ( id );
ALTER TABLE Specializing ADD CONSTRAINT Specializing_Specialty_FK FOREIGN KEY ( specialty_id ) REFERENCES Specialty ( id );
ALTER TABLE Vehicle ADD CONSTRAINT Vehicle_Soldier_FK FOREIGN KEY ( soldier_id ) REFERENCES Soldier ( id );
ALTER TABLE Vehicle ADD CONSTRAINT Vehicle_Vehicle_Type_FK FOREIGN KEY ( vehicle_type_id ) REFERENCES Vehicle_Type ( id );
ALTER TABLE Vehicle ADD CONSTRAINT Vehicle_Storage_FK FOREIGN KEY ( storage_id ) REFERENCES Base ( id );
