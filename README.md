# 417Final

This is a sample Selenium Automated Web Testing util library and implementation. The util 
library is Automato.java and holds bare-bones setup and wrappers for basic 
Selenium commands.

The actual test suite opens a chromedriver to amazon.com, attempts to sign in, and 
verifies that certain error elements appear on the page. At the time of creation, Amazon
would serve two slightly different pages, so some duct tape retry logic was applied to
attempt to find the alternate elements.

This is unversioned and unmaintained code.
