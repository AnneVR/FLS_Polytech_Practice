class WebClient {
    private token: string;

    constructor() {
        this.token = "";
    }

    public setToken(newToken: string) {
        this.token = newToken;
    }

    public async fetch<T, V>(
        url: RequestInfo,
        options: RequestInit = {},
        mapper: (resp: T) => V
    ) {
        const optionsWithToken = this.token
            ? {
                  ...options,
                  headers: {
                      ...(options.headers || {}),
                      Authorization: `Bearer ${this.token}`
                  }
              }
            : options;

        let resp = await fetch(url, optionsWithToken);
        let val = await resp.json();
        if (resp.ok) {
            // TODO Handle map errors ?
            return mapper(val);
        }

        throw val;
    }
}

export const client = new WebClient();
