import plotly.express as px
from pytrends.request import TrendReq

print("Hello there, this program can help you find historic topics data from Google trends.")
print()
print("Please choose from the following list:")
print("(type the number you would like to select)")
print("1. Search a topic within a market for historical trends")
print("2. Search the top global topics during a specified year")

while True:
    userOp1 = input()

    if userOp1 == '1' or userOp1 == '2':
        break
    else:
        print("Please enter a valid number between 1 and 3:")

if userOp1 == '1':
    print("What country would you like to query? (use the full name)")
    userMarket = input().lower().replace(" ","_")
    print("What topic would you like to search?")
    userTopic = input().lower()
    print("Would you like a table view or a chart view of the topic trend over time?")
    print("1. Table view")
    print("2. Chart view")
    print("3. Both")

    while True:
        userView = input()

        if userView == '1' or userView == '2' or userView == '3':
            break
        else:
            print("Please enter a valid number between 1 and 3:")

    pytrends = TrendReq(hl='en-US', tz=360)
    pytrends.trending_searches(pn=userMarket)
    kw_list = [userTopic]
    pytrends.build_payload(kw_list, cat=0, timeframe='today 12-m')
    data = pytrends.interest_over_time()
    data = data.reset_index()
    fig = px.line(data, x="date", y=kw_list, title='Keyword Web Search Interest Over Time')

    if userView == '1':
        print(data)
    elif userView == '2':
        fig.show()
    else:
        print(data)
        fig.show()
else:
    print("What year would you like to search?")

    while True:
        userYear = input()

        if userYear.isnumeric() and len(userYear) == 4:
            break
        else:
            print("Please enter a valid number")

    pytrend = TrendReq()
    df = pytrend.top_charts(userYear, hl='en-US', tz=300, geo='GLOBAL')
    results = df.head()

    print(results)