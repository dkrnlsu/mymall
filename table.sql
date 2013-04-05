
-- 고객
CREATE TABLE "tblUsers"
(
"userId" character varying(100) NOT NULL,     -- 고객ID (이메일주소)
"userPw" character varying(50) NOT NULL,      -- 패스워드
"userName" character varying(50) NOT NULL,    -- 고객명
"cyberMoney" integer NOT NULL DEFAULT 100000, -- 사이버머니
"phone" character varying(20) NOT NULL,       -- 전화
"zipCode" character varying(10) NOT NULL,     -- 우편번호
"addr" character varying(200) NOT NULL,       -- 주소
"createdDate" timestamp without time zone NOT NULL DEFAULT now(), -- 가입일
CONSTRAINT "tblUsers_pk" PRIMARY KEY ("userId")
)


-- 상품
CREATE TABLE "tblProducts"
(
"productId" serial NOT NULL,                  -- 상품ID
"productName" character varying(50) NOT NULL, -- 상품명
"productImage" character varying(100) NOT NULL, -- 상품이미지
"price" integer NOT NULL,                     -- 상품가격
"quantity" integer NOT NULL,                  -- 수량
"status" character varying(1) NOT NULL,       -- 상태 (1:판매, 0:판매중지)
"createdDate" timestamp without time zone NOT NULL DEFAULT now(), -- 등록일
CONSTRAINT "tblProducts_pk" PRIMARY KEY ("productId"),
UNIQUE ("productName")
)

-- 주문
CREATE TABLE "tblOrders"
(
"orderId" serial NOT NULL,                    -- 주문번호
"productId" serial NOT NULL REFERENCES "tblProducts" ("productId"),                  -- 상품ID
"userId" character varying(100) NOT NULL REFERENCES "tblUsers" ("userId"),     -- 고객ID (이메일주소)
"quantity" integer NOT NULL,                  -- 수량
"payment" integer NOT NULL,                   -- 결제금액
"toName" character varying(50) NOT NULL,      -- 받는사람
"toPhone" character varying(20) NOT NULL,     -- 받는사람 전화
"toZipCode" character varying(10) NOT NULL,   -- 받는사람 우편번호
"toAddr" character varying(200) NOT NULL,     -- 받는사람 주소
"memo" character varying(100),                -- 메모
"status" character varying(1) NOT NULL,       -- 상태 (E:주문완료 S:발송완료 C:취소)
"createdDate" timestamp without time zone NOT NULL DEFAULT now(), -- 주문일
CONSTRAINT "tblOrder_pk" PRIMARY KEY ("orderId")
)



insert into "tblUsers" values ('test', '1234', '홍길동', 1000000, '010-1111-2222', '111-111', '경기도 성남시 판교동 좋은아파트 1동 1004호');

insert into "tblOrders" ("productId", "userId", quantity, payment, "toName", "toPhone", "toZipCode", "toAddr", memo, status) values (3, 'test', 1, 20000, '오지현', '010-6224-8252', '111-111', '경기도 광명시 좋은아파트 1동 1004호', '', 'E');