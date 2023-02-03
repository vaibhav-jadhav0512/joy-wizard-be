package com.joy.wizard.be.queries;

public class JoyWizardQueries {

	public static final String GET_QUESTIONS = "SELECT qid, question, `input` " + "FROM joywizard.questions";
	public static final String SAVE_SURVEY = "INSERT INTO joywizard.questions_ans_rel (uid, qid, ans) VALUES(:uid, :qid, :ans)";
	public static final String GET_ANSWERS = "SELECT avg(ans),a.question,uid,b.qid  FROM joywizard.questions_ans_rel b,joywizard.questions a where a.qid =b.qid  group by b.qid";
	public static final String GET_MAX_QID = "select max(cast(qid as UNSIGNED)) from `joywizard`.`questions`";
	public static final String SAVE_QUESTION = "INSERT INTO joywizard.questions (qid, question, `input`) VALUES(:qid, :question, :input)";
}
