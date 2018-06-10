<?php
namespace Trivia;

include __DIR__.'/Game.php';

function play() {
$notAWinner;

  $aGame = new Game();
  
  $aGame->add("Chet");
  $aGame->add("Pat");
  $aGame->add("Sue");
  
  
  do {
    
    $aGame->roll(rand(0,5) + 1);
    
    if (rand(0,9) == 7) {
      $notAWinner = $aGame->wrongAnswer();
    } else {
      $notAWinner = $aGame->wasCorrectlyAnswered();
    }
    
    
    
  } while ($notAWinner);
  
}

if ( basename(__FILE__) == basename($_SERVER["SCRIPT_FILENAME"]) ) {
    play();
}
