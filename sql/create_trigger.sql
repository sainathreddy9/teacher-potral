CREATE OR REPLACE
    TRIGGER trg_audit_student_attendance
    after  update
		OF attn_status
		ON student_attendance
		FOR EACH ROW
	WHEN (NEW.attn_status <> OLD.attn_status)
    DECLARE
    	
    BEGIN
         INSERT INTO audit_student_attendance
		 (
			class_attn_id,
			student_id,
			attn_status,
			prev_teacher_id,
			updated_teacher_id,
			CREATED_TIME
		 )
		 values
		 (
			:NEW.class_attn_id,
			:NEW.student_id,
			:NEW.attn_status,
			:OLD.updated_by,
			:NEW.updated_by,
			CURRENT_TIMESTAMP
		 );
    end;
    /