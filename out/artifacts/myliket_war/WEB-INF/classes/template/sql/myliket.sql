
-- myliket 스키마 생성 
CREATE DATABASE `myliket` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- 카테고리 상세정보 테이블(category table) 생성
CREATE TABLE `category` (
  `categoryId` binary(16) NOT NULL COMMENT '카테고리 아이디',
  `categoryName` varchar(64) NOT NULL COMMENT '카테고리 이름',
  `categoryState` varchar(2) NOT NULL COMMENT '카테고리 상태 코드',
  `categoryCreatedAt` datetime NOT NULL COMMENT '최초 등록일자',
  `categoryUpdatedAt` datetime DEFAULT NULL COMMENT '최근 수정일자',
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='카테고리 상세정보';

-- 카테고리 상세정보 DB
INSERT INTO category VALUES ( UNHEX('57E28D94037340779DAF421C2C493789') , '등록 테스트', 'CY', now(), now());
INSERT INTO category VALUES ( UNHEX('57E28D94037340779DAF421C2C493790') , '등록 테스트', 'CY', now(), now());
INSERT INTO category VALUES ( UNHEX('57E28D94037340779DAF421C2C493791') , '등록 테스트', 'CY', now(), now());



-- 할일 상세정보 테이블(tododeteil table) 생성 
 CREATE TABLE `tododetail` (
  `todoNo` int NOT NULL AUTO_INCREMENT COMMENT '할일 고유번호',
  `categoryId` binary(16) NOT NULL COMMENT ' 카테고리 아이디',
  `todoTitle` varchar(64) NOT NULL COMMENT '할일 제목',
  `todoContent` varchar(100) NOT NULL COMMENT '할일 내용',
  `todoDay` date NOT NULL COMMENT '할일 예정 일자',
  `todoTime` time DEFAULT NULL COMMENT '할일 예정 시간',
  `todoState` varchar(2) NOT NULL COMMENT '할일 상태 코드',
  `todoCreatedAt` datetime NOT NULL COMMENT '할일 최초 등록일시',
  `todoUpdatedAt` datetime DEFAULT NULL COMMENT '할일 최근 수정일시',
  PRIMARY KEY (`todoNo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COMMENT='할일 상세정보';

-- 할일 상세정보 DB

INSERT  INTO tododetail (categoryId,todoTitle, todoContent, todoDay, todoTime, todoState, todoCreatedAt, todoUpdatedAt) 
VALUES( UNHEX('57E28D94037340779DAF421C2C493789'),'할일의 제목', '할일의 내용입니다.', '2022-09-01', '10:00:00', 'TR' , now(), now()); 

INSERT  INTO tododetail (categoryId,todoTitle, todoContent, todoDay, todoTime, todoState, todoCreatedAt, todoUpdatedAt) 
VALUES( UNHEX('57E28D94037340779DAF421C2C493790'),'할일의 제목', '할일의 내용입니다.', '2022-09-02', '11:00:00', 'TR' , now(), now()); 

INSERT  INTO tododetail (categoryId,todoTitle, todoContent, todoDay, todoTime, todoState, todoCreatedAt, todoUpdatedAt) 
VALUES( UNHEX('57E28D94037340779DAF421C2C493789'),'할일의 제목', '할일의 내용입니다.', '2022-09-03', '12:00:00', 'TR' , now(), now()); 

 

-- 공통 상태코드 테이블 생성 (grbstate table) 생성
CREATE TABLE `grbstate` (
  `stateCode` varchar(2) NOT NULL COMMENT '상태 코드',
  `stateKor` varchar(10) NOT NULL COMMENT '상태코드 한글명',
  `stateCategory` varchar(20) NOT NULL COMMENT '카테고리',
  PRIMARY KEY (`stateCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='공통 상태 코드';

-- 공통 상태코드 DB 
INSERT INTO grbstate VALUES ( 'CY' , '사용', 'categoryState');
INSERT INTO grbstate VALUES ( 'CN' , '미사용', 'categoryState');
INSERT INTO grbstate VALUES ( 'TR' , '예정', 'todoState');
INSERT INTO grbstate VALUES ( 'TD' , '삭제', 'todoState');
INSERT INTO grbstate VALUES ( 'TC' , '완료', 'todoState');







