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

        let resp = await fetch(url, optionsWithToken).then((resp) => {
            // TODO - check if works
            if (resp.status == 402) {
                // Очистить токен, перезагрузить страницу.
            }
            return resp;
        });
        let val = await resp.json();
        if (resp.ok) {
            // TODO Handle map errors ?
            return mapper(val);
        }

        throw val;
    }
}

export const client = new WebClient();
