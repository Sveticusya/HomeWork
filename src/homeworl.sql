create table public.test( 
id serial4 NOT NULL, 
CONSTRAINT test_pk PRIMARY KEY (id)); 
 
create TABLE public.question ( 
id serial4 NOT NULL, 
test_id int4, 
description varchar(100), 
CONSTRAINT questions_pk PRIMARY KEY (id)); 
 
 
CREATE TABLE public.answer ( 
id serial4 NOT NULL, 
"description" varchar(100), 
is_right boolean, 
question_id int4, 
CONSTRAINT answer_pk PRIMARY KEY (id)); 
 
ALTER TABLE public.question   
ADD CONSTRAINT question_fk FOREIGN KEY (test_id) REFERENCES public.test(id); 
 
ALTER TABLE public.answer  
ADD CONSTRAINT answer_fk FOREIGN KEY (question_id) REFERENCES public.question(id);