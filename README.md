## [Synopsis](#synopsis)

PingClient is a sample library that shows how to communicate with Ping to get a JSON String of all users and all groups.

[Download](https://github.com/kclark-jenkins/PingCalls/releases)

[Synopsis](#synopsis)

[Usage](#usage)

[Contributors](#contributors)

[License](#license)

#### Usage

Either decompress the jar and modify ping.properties to match your API Key and Client ID or compile this from source making sure to change these fields in ping.properties

Include PingClient-0.0.1-Alpha-20161023115214-SNAPSHOT.jar in your classpath

```
System.out.println(new PingClient().getAllUsers());
System.out.println(new PingClient().getAllGroups());
```

## [Contributors](#contributors)

Kristopher Clark

## [License](#license)

[MIT License](https://github.com/kclark-jenkins/OTCookbook/blob/master/LICENSE)