package com.example.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exceptions.FriendNotFoundException;
import com.example.model.beans.Friend;
import com.example.model.dao.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendRepository friendDao;
	
	@Override
	@Transactional
	public Friend addFriend(int profileIdRef, Friend friend) {
		// to make it simple we will not enter profile id that doesn't exist in the Profile
		friend.setProfileIdRef(profileIdRef);
		return friendDao.save(friend);
	}
	
	@Override
	public Friend removeFriend(int profileIdRef, long friendId) throws FriendNotFoundException {
		List<Friend> friends = friendDao.getFriendsFromProfile(profileIdRef);
		Friend friend;
		for (Friend f: friends) {
			if(f.getId() == friendId) {
				friend = f;
				friendDao.delete(friend);
				return friend;
			}
		}
		throw new FriendNotFoundException("Friend with an id " + friendId + " not found");
	}

}
