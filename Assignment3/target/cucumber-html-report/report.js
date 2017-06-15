$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test/java/huffingTonPost/feature.feature");
formatter.feature({
  "line": 1,
  "name": "Checking article of HuffingtonPost website",
  "description": "",
  "id": "checking-article-of-huffingtonpost-website",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "HuffingtonPost website exists",
  "description": "",
  "id": "checking-article-of-huffingtonpost-website;huffingtonpost-website-exists",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@featureList"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I have open the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I open HuffingtonPost website",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "LifeStyle label should exits",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Click on Lifestyle tab",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "verify tech link is visible",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Select tech link",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "verify title of tech page",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Read Articles Data and verify links",
  "keyword": "And "
});
formatter.match({
  "location": "Test.openBrowser()"
});
formatter.result({
  "duration": 4321300490,
  "status": "passed"
});
formatter.match({
  "location": "Test.goToHuffingtonPost()"
});
formatter.result({
  "duration": 35925866111,
  "status": "passed"
});
formatter.match({
  "location": "Test.verifyLifestyletab()"
});
formatter.result({
  "duration": 46664680,
  "status": "passed"
});
formatter.match({
  "location": "Test.selectLifestyle()"
});
formatter.result({
  "duration": 36664349,
  "status": "passed"
});
formatter.match({
  "location": "Test.verifyLTechLink()"
});
formatter.result({
  "duration": 647730102,
  "status": "passed"
});
formatter.match({
  "location": "Test.selectTechLink()"
});
formatter.result({
  "duration": 8783901470,
  "status": "passed"
});
formatter.match({
  "location": "Test.verifyTechpage()"
});
formatter.result({
  "duration": 10694610,
  "status": "passed"
});
formatter.match({
  "location": "Test.readArticle()"
});
formatter.result({
  "duration": 22256999735,
  "status": "passed"
});
});