package login;

public class LoginTester3 {

	private static String dbPwd = "x";
	private static String requestPwd = "y";
	private static String requestUser = "DD";
	private static String[] DBUsersArray = {"AaA", "bBb", "c", "dd", "dD", "Dd"};//these users have same pwd 
	private static String msg = "blah";

	public static void main(String[] args) {
		msg = "start";
		System.out.println(msg);
		run();
	}
	public static String run() {
		// String[] DBUsers = getList(String partner, String pwd);
		int i = 0;
		if (DBUsersArray.length == 0) {
			msg = "DBUsers list empty. pwd not found";
			System.out.println(msg);
			return msg;
		} else {
			System.out.println("starting iteration via "+DBUsersArray.length +" found users");
			for (String dbUser : DBUsersArray) {
				if (!dbUser.toLowerCase().equals(requestUser.toLowerCase())) {
					// user not found
					msg = "1 user NOT found so far i=" + i + " dbuser=" + dbUser + " requestuser=" + requestUser + " continue";
					System.out.println(msg);
					i++;
					continue;// check next user in the list
					// and not
					// return "user not found"
				} else {

					// user found
					// if (dbPwd.equals(requestPwd)) {
					msg = "2 SUCCESS  user found. pwd match. DBUser=" + dbUser + " requestUser=" + requestUser + " dbPwd=" + dbPwd + " requestPwd=" + requestPwd;
					System.out.println(msg);
					return msg;
					// }
					// else {
					// //user found but pwd wrong
					// System.out.println("2 user found and pwd wrong i="+i+" dbuser="+dbUser+" requestuser="+requestUser+" continue");
					// i++;
					// continue;// check next user in the list
					// //and not
					// //return "pwd wrong";
					// }
				}
			}// end of for
			msg = "end of loop";
			System.out.println(msg);
			return "end of loop";
		}// end of if not empty list
	}
}
