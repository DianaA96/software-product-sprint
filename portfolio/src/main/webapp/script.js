// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random fun fact to the page.
 */
function addRandomFunFact() {
  const funFacts =
      ['I love chocolate', 'I love tacos but hate onion', 'I want to write a book in the future', 'I am afraid of the dark'];

  // Pick a random funfact.
  const funFact = funFacts[Math.floor(Math.random() * funFacts.length)];

  // Add it to the page.
  const funFactContainer = document.getElementById('funFact-container');
  funFactContainer.innerText = funFact;
}

// Getting practice with servlets!
async function showmyTurnServlet() {
  const responseFromServer = await fetch('/ihopethisworks');
  const textFromResponse = await responseFromServer.text();

  const dateContainer = document.getElementById('myTurnServletContainer');
  dateContainer.innerText = textFromResponse;
}