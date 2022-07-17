# Prototype: Selenium end-to-end testing using Spock

This is a PoC to learn about end-to-end testing using a Selenium web driver
along with the Spock framework.

This is a Spring Boot application, so it has all the Boot niceties. 

## API
There's only one API endpoint: `/hello/{your_name}`.
It will return the string "Hello, ${your_name}"

## Testing
The main point is proving out that it's possible to use a web driver to make assertions
against an application running on a browser.