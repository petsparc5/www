package com.clean.communication;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.clean.shipgame.GameWithShips;
import com.clean.shipgame.Status;

public class TorpedoProtocolTest {

    private TorpedoProtocol underTest;
    private GameWithShips gameWithShip;
    
    @Before
    public void setUp(){
        gameWithShip = EasyMock.createMock(GameWithShips.class);
        underTest = new TorpedoProtocol(gameWithShip);
    }
    
    @Test
    public void testProcessInputShouldReturnMiss(){
        //GIVEN
        EasyMock.expect(gameWithShip.fire(1, 1)).andReturn(Status.MISS);
        EasyMock.replay(gameWithShip);
        //WHEN
        String expected = Status.MISS.name().toLowerCase();
        //THEN
        String actual = underTest.processInput("fire 1 1");
        EasyMock.verify(gameWithShip);
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void testProcessInputShouldReturnHit(){
        //GIVEN
        EasyMock.expect(gameWithShip.fire(1, 1)).andReturn(Status.HIT);
        EasyMock.replay(gameWithShip);
        //WHEN
        String expected = Status.HIT.name().toLowerCase();
        //THEN
        String actual = underTest.processInput("fire 1 1");
        EasyMock.verify(gameWithShip);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testProcessInputShouldReturnSunk(){
        //GIVEN
        EasyMock.expect(gameWithShip.fire(1, 1)).andReturn(Status.SUNK);
        EasyMock.replay(gameWithShip);
        //WHEN
        String expected = Status.SUNK.name().toLowerCase();
        //THEN
        String actual = underTest.processInput("fire 1 1");
        EasyMock.verify(gameWithShip);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testProcessInputShouldReturnWin(){
        //GIVEN
        EasyMock.expect(gameWithShip.fire(1, 1)).andReturn(Status.WIN);
        EasyMock.replay(gameWithShip);
        //WHEN
        String expected = Status.WIN.name().toLowerCase();
        //THEN
        String actual = underTest.processInput("fire 1 1");
        EasyMock.verify(gameWithShip);
        Assert.assertEquals(expected, actual);
    }
}
