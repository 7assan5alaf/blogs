package com.hk.blog.message;

public class Message {
	
	private final String messageUser="Welcome to our site\n" +
            "You can write alot of blogs in our site and see all users" +
            "We wish you all the best\n" +
            "Thank you for registering on our site";
    private final String subject="Welcome to Blog online";
    private final String from="artgallery623@gmail.com";
    
	public Message() {
	}
	public String getMessageUser() {
		return messageUser;
	}
	public String getSubject() {
		return subject;
	}
	public String getFrom() {
		return from;
	}
    

}
